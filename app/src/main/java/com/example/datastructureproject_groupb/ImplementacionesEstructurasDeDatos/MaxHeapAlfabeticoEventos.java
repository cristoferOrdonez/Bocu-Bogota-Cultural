package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;


import com.example.datastructureproject_groupb.entidades.evento.Evento;

import java.util.HashMap;
import java.util.Map;

public class MaxHeapAlfabeticoEventos {
    private DynamicUnsortedList<Evento> heap;
    private int size;
    private Map<Evento, Integer> indexMap;

    public MaxHeapAlfabeticoEventos() {
        heap = new DynamicUnsortedList<>();
        size = 0;
        indexMap = new HashMap<>();
    }


    public MaxHeapAlfabeticoEventos(DynamicUnsortedList<Evento> arr){
        heap = arr;
        size = arr.size();
        indexMap = new HashMap<>();

        for(int i = (arr.size() - 1) / 2; i > -1; i--)
            heapifyDown(i);

    }

    public DynamicUnsortedList<Evento> heapSort(){

        for(int i = size - 1; i > 0; i--){

            swap(0, i);
            size--;
            heapifyDown(0);

        }

        return heap;

    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Evento value) {

        heap.insert(value);
        indexMap.put(value, size);
        size++;
        heapifyUp(size - 1);
    }

    public Evento remove(Evento value) {
        Integer index = indexMap.get(value);
        if (index == null) {
            throw new IllegalArgumentException("Value not found in the heap");
        }

        Evento removedValue = heap.get(index);
        heap.set(index, heap.get(size - 1));
        indexMap.put(heap.get(size - 1), index);
        indexMap.remove(value);
        size--;

        if (index < size) {
            heapifyDown(index);
            if (index > 0 && heap.get(index).getNombreEvento().toLowerCase().compareTo(heap.get((index - 1) / 2).getNombreEvento()) > 0) {
                heapifyUp(index);
            }
        }

        return removedValue;
    }

    public Evento extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        Evento max = heap.get(0);
        heap.set(0, heap.get(size - 1));
        indexMap.put(heap.get(size - 1), 0);
        indexMap.remove(max);
        size--;
        heapifyDown(0);

        return max;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).getNombreEvento().compareToIgnoreCase(heap.get(parentIndex).getNombreEvento()) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        while (true) {
            int leftChildIndex = 2 * largest + 1;
            int rightChildIndex = 2 * largest + 2;

            if (leftChildIndex < size && heap.get(leftChildIndex).getNombreEvento().compareToIgnoreCase(heap.get(largest).getNombreEvento()) > 0) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < size && heap.get(rightChildIndex).getNombreEvento().compareToIgnoreCase(heap.get(largest).getNombreEvento()) > 0) {
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
        heap.set(i,heap.get(j));
        heap.set(j, temp);
        indexMap.put(heap.get(i), i);
        indexMap.put(heap.get(j), j);
    }

}

