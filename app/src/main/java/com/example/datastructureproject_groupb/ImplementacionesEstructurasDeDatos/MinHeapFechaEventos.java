package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;


import com.example.datastructureproject_groupb.entidades.evento.Evento;

public class MinHeapFechaEventos {
    private DynamicUnsortedList<Evento> heap;
    private int size;

    public MinHeapFechaEventos() {
        heap = new DynamicUnsortedList<>();
        size = 0;
    }

    public MinHeapFechaEventos(DynamicUnsortedList<Evento> arr){
        heap = arr;
        size = arr.size();

        for(int i = (arr.size() - 1) / 2; i > -1; i--)
            siftDown(i);

    }

    public DynamicUnsortedList<Evento> heapSort(){

        for(int i = size - 1; i > 0; i--){

            swap(0, i);
            size--;
            siftDown(0);

        }

        return heap;

    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Evento evento) {
        if (size == heap.size()) {
            throw new IllegalStateException("Heap is full");
        }

        heap.insert(evento);
        size++;
        siftUp(size - 1);
    }

    public Evento remove(Evento evento) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap.get(i) == evento) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Value not found in the heap");
        }

        Evento removedEvento = heap.get(index);
        heap.set(index, heap.get(size - 1));
        size--;

        if (index < size) {
            siftDown(index);
            if (heap.get(index).getCostoEvento() < heap.get((index - 1) / 2).getCostoEvento()) {
                siftUp(index);
            }
        }

        return removedEvento;
    }

    public Evento extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        Evento max = heap.get(0);
        heap.set(0, heap.get(size - 1));
        size--;
        siftDown(0);

        return max;
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).getFechaEvento().before(heap.get(parentIndex).getFechaEvento())) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int largest = index;
        while (true) {
            int leftChildIndex = 2 * largest + 1;
            int rightChildIndex = 2 * largest + 2;

            if (leftChildIndex < size && heap.get(leftChildIndex).getFechaEvento().before(heap.get(largest).getFechaEvento())) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < size && heap.get(rightChildIndex).getFechaEvento().before(heap.get(largest).getFechaEvento())){
                largest = rightChildIndex;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Evento temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}
