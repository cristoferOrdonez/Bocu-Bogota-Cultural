package com.example.datastructureproject_groupb.fragments;

import static com.example.datastructureproject_groupb.entidades.pagina_descubrir.OrdenEventos.ALFABETICO_A_Z;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.datastructureproject_groupb.Bocu;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.DynamicUnsortedList;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MaxHeapAlfabeticoEventos;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MaxHeapCostoEventos;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MaxHeapFechaEventos;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MinHeapCostoEventos;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MinHeapFechaEventos;
import com.example.datastructureproject_groupb.entidades.pagina_descubrir.OrdenEventos;

import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.MinHeapAlfabeticoEventos;
import com.example.datastructureproject_groupb.R;
import com.example.datastructureproject_groupb.adaptadores.AdaptadorPaginaDescubrir;
import com.example.datastructureproject_groupb.entidades.evento.Evento;
import com.example.datastructureproject_groupb.pickers.MostrarDatePicker;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

import java.text.NumberFormat;
import java.util.Locale;

public class DescubrirFragment extends Fragment {

    TextInputEditText nombreEvento, fechaEvento, costoMinimoEvento, costoMaximoEvento;
    MaterialAutoCompleteTextView spinnerLocalidadEvento, spinnerCategoriaEvento;
    private Integer[] fecha = {0, -1, 0};
    Button botonAceptarFiltros;
    ImageButton botonIniciarFiltros;
    private ArrayAdapter<String> categoriasAdapter, costoAdapter, localidadesAdapter;
    private LinearLayout layoutBoton, layoutCostoEvento;
    private TextInputLayout layoutNombreEvento, layoutFechaEvento, layoutCostoMinimoEvento, layoutCostoMaximoEvento, layoutLocalidadEvento, layoutTipoEvento;
    RecyclerView listaEventos;

    public DescubrirFragment() {
    }

    public static DescubrirFragment newInstance() {
        DescubrirFragment fragment = new DescubrirFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root;

        if (Bocu.filtrosEventos.length == 0) {
            root = establecerContenidoFiltros(inflater, container);
        } else {
            root = establecerContenidoEventosFiltrados(inflater, container);
        }

        return root;

    }

    public View establecerContenidoFiltros(LayoutInflater inflater, ViewGroup container) {
        View root = inflater.inflate(R.layout.fragment_filtros_descubrir, container, false);

        layoutNombreEvento = root.findViewById(R.id.layoutNombreEvento);
        layoutFechaEvento = root.findViewById(R.id.layoutFechaEvento);
        layoutLocalidadEvento = root.findViewById(R.id.layoutLocalidadEvento);
        layoutCostoEvento = root.findViewById(R.id.layoutCostoEvento);
        layoutTipoEvento = root.findViewById(R.id.layoutTipoEvento);
        layoutCostoMinimoEvento = root.findViewById(R.id.layoutCostoMinimo);
        layoutCostoMaximoEvento = root.findViewById(R.id.layoutCostoMaximo);
        layoutBoton = root.findViewById(R.id.layoutBotones);

        nombreEvento = root.findViewById(R.id.editTextNombreEvento);
        fechaEvento = root.findViewById(R.id.editTextFechaEvento);
        costoMinimoEvento = root.findViewById(R.id.editTextCostoMinimo);
        costoMaximoEvento = root.findViewById(R.id.editTextCostoMaximo);

        spinnerCategoriaEvento = root.findViewById(R.id.spinnerCategoriaEvento);
        spinnerLocalidadEvento = root.findViewById(R.id.spinnerLocalidadEvento);

        botonAceptarFiltros = root.findViewById(R.id.botonAplicarFiltros);

        fechaEvento.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus)
                mostrarDatePicker();
        });
        fechaEvento.setOnClickListener(view -> mostrarDatePicker());

        KeyboardVisibilityEvent.setEventListener(getActivity(), isOpen -> {
            if(isOpen) {

                LinearLayout.LayoutParams nuevoParametro = (LinearLayout.LayoutParams) layoutBoton.getLayoutParams();
                nuevoParametro.width = 0;
                nuevoParametro.weight = 0;
                layoutBoton.setLayoutParams(nuevoParametro);

            } else {

                LinearLayout.LayoutParams nuevoParametro = (LinearLayout.LayoutParams) layoutBoton.getLayoutParams();

                nuevoParametro.width = ViewGroup.LayoutParams.MATCH_PARENT;
                nuevoParametro.weight = 1.9f;

                layoutBoton.setLayoutParams(nuevoParametro);

            }
        });

        localidadesAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item_dropdown_menu, Bocu.LOCALIDADES);
        spinnerLocalidadEvento.setAdapter(localidadesAdapter);

        categoriasAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item_dropdown_menu, Bocu.INTERESES);
        spinnerCategoriaEvento.setAdapter(categoriasAdapter);

        // Deshabilita el setErrorEnable después de un intento de filtrado fallido
        deshabilitarSetError(nombreEvento, layoutNombreEvento);
        deshabilitarSetError(fechaEvento, layoutFechaEvento);
        deshabilitarSetError(costoMinimoEvento, layoutCostoMinimoEvento);
        deshabilitarSetError(costoMaximoEvento, layoutCostoMaximoEvento);
        deshabilitarSetError(spinnerLocalidadEvento, layoutLocalidadEvento);
        deshabilitarSetError(spinnerCategoriaEvento, layoutTipoEvento);

        formatoCostoDinero(costoMinimoEvento);
        formatoCostoDinero(costoMaximoEvento);

        botonAceptarFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = true;

                if (nombreEvento.getText().toString().trim().equals("") &&
                        fechaEvento.getText().toString().trim().equals("") &&
                        spinnerLocalidadEvento.getText().toString().equals("") &&
                        costoMinimoEvento.getText().toString().equals("") &&
                        costoMaximoEvento.getText().toString().equals("") &&
                        spinnerCategoriaEvento.getText().toString().equals("")) {
                    layoutNombreEvento.setError("Debe ingresar mínimo un filtro");
                    flag = false;
                }

                if (flag) {
                    String nombre = nombreEvento.getText().toString();
                    String fecha = fechaEvento.getText().toString();
                    String localidad = spinnerLocalidadEvento.getText().toString();
                    String costoMinimo = costoMinimoEvento.getText().toString();
                    String costoMaximo = costoMaximoEvento.getText().toString();
                    String categoria = spinnerCategoriaEvento.getText().toString();
                    Bocu.filtrosEventos = new String[]{nombre, fecha, localidad, costoMinimo, costoMaximo, categoria};
                    openFragment();
                }
            }
        });
        return root;
    }

    public View establecerContenidoEventosFiltrados(LayoutInflater inflater, ViewGroup container) {
        View root = inflater.inflate(R.layout.fragment_eventos_filtrados_pagina_descubrir, container, false);
        setHasOptionsMenu(true);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar_menu_ordenar_eventos);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        DynamicUnsortedList<Evento> eventosFiltrados = aplicarFiltros(Bocu.filtrosEventos);
        DynamicUnsortedList<Evento> eventosOrdenados = new DynamicUnsortedList<Evento>();

        if (Bocu.ordenEventos != null) {
            switch (Bocu.ordenEventos) {
                case ALFABETICO_A_Z:
                    eventosOrdenados = new MaxHeapAlfabeticoEventos(eventosFiltrados).heapSort();
                    break;
                case ALFABETICO_Z_A:
                    eventosOrdenados = new MinHeapAlfabeticoEventos(eventosFiltrados).heapSort();
                    break;
                case FECHA_RECIENTE:
                    eventosOrdenados = new MaxHeapFechaEventos(eventosFiltrados).heapSort();
                    break;
                case FECHA_MENOS_RECIENTE:
                    eventosOrdenados = new MinHeapFechaEventos(eventosFiltrados).heapSort();
                    break;
                case MAYOR_COSTO:
                    eventosOrdenados = new MinHeapCostoEventos(eventosFiltrados).heapSort();
                    break;
                case MENOR_COSTO:
                    eventosOrdenados = new MaxHeapCostoEventos(eventosFiltrados).heapSort();
                    break;
            }
        } else {
            eventosOrdenados = eventosFiltrados;
        }

        listaEventos = root.findViewById(R.id.recyclerViewEventosFiltradosPaginaDescubrir);

        listaEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        if (eventosOrdenados.size() != 0) {
            AdaptadorPaginaDescubrir adapter = new AdaptadorPaginaDescubrir(eventosOrdenados);
            listaEventos.setAdapter(adapter);
        } else {
            AdaptadorPaginaDescubrir adapter = new AdaptadorPaginaDescubrir(eventosFiltrados);
            listaEventos.setAdapter(adapter);
        }

        botonIniciarFiltros = root.findViewById(R.id.botonFiltrarEventos);

        botonIniciarFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bocu.filtrosEventos = new String[]{};
                openFragment();
            }
        });

        return root;
    }

    private void mostrarDatePicker() {
        MostrarDatePicker datePicker = new MostrarDatePicker(getContext(), this.fechaEvento, this.fecha);
    }

    private void openFragment() {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContenedor, DescubrirFragment.newInstance());
        fragmentTransaction.commit();
    }

    private void formatoCostoDinero(TextInputEditText textInputCosto) {
        textInputCosto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No es necesario
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No es necesario
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();

                String digitsOnly = input.replaceAll("[^\\d]", "");
                String formattedCost = formatearCosto(digitsOnly);

                if (!textInputCosto.getText().toString().equals(formattedCost)) {
                    textInputCosto.removeTextChangedListener(this);

                    textInputCosto.setText(formattedCost);
                    textInputCosto.setSelection(formattedCost.length());

                    textInputCosto.addTextChangedListener(this);
                }
            }

            private String formatearCosto(String input) {
                try {
                    if (input.isEmpty()) {
                        return "";
                    }
                    double costo = Double.parseDouble(input);

                    // Formatear el número como una moneda sin el símbolo de moneda
                    NumberFormat formatoMoneda = NumberFormat.getNumberInstance(new Locale("es", "CO"));
                    formatoMoneda.setMinimumFractionDigits(0); // Elima decimales

                    return formatoMoneda.format(costo);
                } catch (NumberFormatException e) {
                    return "";
                }
            }
        });
    }

    private void deshabilitarSetError(TextInputEditText textInputEditText, TextInputLayout textInputLayout) {
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                textInputLayout.setErrorEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No es necesario
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No es necesario
            }
        });
    }

    private void deshabilitarSetError(MaterialAutoCompleteTextView materialAutoCompleteTextView, TextInputLayout textInputLayout) {
        materialAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                textInputLayout.setErrorEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No es necesario
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No es necesario
            }
        });
    }

    public DynamicUnsortedList<Evento> aplicarFiltros(String[] filtros) {
        DynamicUnsortedList<Evento> eventosFiltrados = Bocu.eventos;
        if (!filtros[0].isEmpty()){
            eventosFiltrados = filtrarEventoPorNombre(filtros[0], eventosFiltrados);
        }

        if (!filtros[1].isEmpty()){
            eventosFiltrados = filtrarEventoPorFecha(filtros[1], eventosFiltrados);
        }

        if (!filtros[2].isEmpty()){
            eventosFiltrados = filtrarEventoPorLocalidad(filtros[2], eventosFiltrados);
        }

        if (!filtros[3].isEmpty() && filtros[4].isEmpty() || filtros[3].isEmpty() && !filtros[4].isEmpty() || !filtros[3].isEmpty()){
            eventosFiltrados = filtrarEventoPorCosto(filtros[3], filtros[4], eventosFiltrados);
        }

        if (!filtros[5].isEmpty()){
            eventosFiltrados = filtrarEventoPorCategoria(filtros[5], eventosFiltrados);
        }

        return eventosFiltrados;
    }

    private DynamicUnsortedList<Evento> filtrarEventoPorNombre(String nombre, DynamicUnsortedList<Evento> eventos) {
        DynamicUnsortedList<Evento> eventosFiltrados = new DynamicUnsortedList<Evento>();

        if (!nombre.equals("")) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getNombreEvento().toLowerCase().contains(nombre.toLowerCase())) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else {
            return eventos;
        }
    }

    private DynamicUnsortedList<Evento> filtrarEventoPorFecha(String fecha, DynamicUnsortedList<Evento> eventos) {
        DynamicUnsortedList<Evento> eventosFiltrados = new DynamicUnsortedList<Evento>();

        if (!fecha.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getFechaEventoString().equals(fecha)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else {
            return eventos;
        }
    }

    private DynamicUnsortedList<Evento> filtrarEventoPorLocalidad(String localidad, DynamicUnsortedList<Evento> eventos) {
        localidadesAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item_dropdown_menu, Bocu.LOCALIDADES);

        DynamicUnsortedList<Evento> eventosFiltrados = new DynamicUnsortedList<Evento>();

        if (!localidad.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getUbicacionEvento() == localidadesAdapter.getPosition(localidad)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else {
            return eventos;
        }
    }

    private DynamicUnsortedList<Evento> filtrarEventoPorCosto(String costoMinimo, String costoMaximo, DynamicUnsortedList<Evento> eventos) {
        DynamicUnsortedList<Evento> eventosFiltrados = new DynamicUnsortedList<Evento>();
        costoMaximo = costoMaximo.replaceAll("\\.", "");
        costoMinimo = costoMinimo.replaceAll("\\.", "");

        if (!costoMinimo.isEmpty() && costoMaximo.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getCostoEvento() >= Integer.parseInt(costoMinimo)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else if (costoMinimo.isEmpty() && !costoMaximo.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getCostoEvento() <= Integer.parseInt(costoMaximo)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else if (!costoMinimo.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getCostoEvento() >= Integer.parseInt(costoMinimo) && eventos.get(i).getCostoEvento() <= Integer.parseInt(costoMaximo)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else {
            return eventos;
        }
    }

    private DynamicUnsortedList<Evento> filtrarEventoPorCategoria(String categoria, DynamicUnsortedList<Evento> eventos) {
        categoriasAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item_dropdown_menu, Bocu.INTERESES);

        DynamicUnsortedList<Evento> eventosFiltrados = new DynamicUnsortedList<Evento>();

        if (!categoria.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getCategoriaEvento() == categoriasAdapter.getPosition(categoria)) {
                    eventosFiltrados.insert(eventos.get(i));
                }
            }
            return eventosFiltrados;
        } else {
            return eventos;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_orden_pagina_descubrir, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.orden_alfabetico_a_z:
                Bocu.ordenEventos = ALFABETICO_A_Z;
                openFragment();
                return true;
            case R.id.orden_alfabetico_z_a:
                Bocu.ordenEventos = OrdenEventos.ALFABETICO_Z_A;
                openFragment();
                return true;
            case R.id.orden_fecha_reciente:
                Bocu.ordenEventos = OrdenEventos.FECHA_RECIENTE;
                openFragment();
                return true;
            case R.id.orden_fecha_antigua:
                Bocu.ordenEventos = OrdenEventos.FECHA_MENOS_RECIENTE;
                openFragment();
                return true;
            case R.id.orden_mayor_costo:
                Bocu.ordenEventos = OrdenEventos.MAYOR_COSTO;
                openFragment();
                return true;
            case R.id.orden_menor_costo:
                Bocu.ordenEventos = OrdenEventos.MENOR_COSTO;
                openFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}