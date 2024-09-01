package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;

import com.example.datastructureproject_groupb.entidades.evento.Evento;

import java.util.HashMap;
import java.util.Map;

public class MinHeapAlfabeticoEventos{
    private DynamicUnsortedList<Evento> heap;
    private int size;
    private Map<Evento, Integer> indexMap;

    public MinHeapAlfabeticoEventos() {
        this.size = 0;
        this.heap = new DynamicUnsortedList<>();
        this.indexMap = new HashMap<>();
    }
    public MinHeapAlfabeticoEventos(DynamicUnsortedList<Evento> arr){
        heap = arr;
        size = arr.size();
        indexMap = new HashMap<>();

        for(int i = (arr.size() - 1) / 2; i > -1; i--)
            heapifyDown();

    }

    public DynamicUnsortedList<Evento> heapSort(){

        for(int i = size - 1; i > 0; i--){

            swap(0, i);
            size--;
            heapifyDown();

        }

        return heap;

    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private void swap(int index1, int index2) {
        Evento temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
        indexMap.put(heap.get(index1), index1);
        indexMap.put(heap.get(index2), index2);
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap.get(index).getNombreEvento().compareToIgnoreCase(heap.get(getParentIndex(index)).getNombreEvento()) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap.get(getRightChildIndex(index)).getNombreEvento().compareToIgnoreCase(heap.get(smallerChildIndex).getNombreEvento()) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap.get(index).getNombreEvento().compareToIgnoreCase(heap.get(smallerChildIndex).getNombreEvento()) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    public void insert(Evento value) {

        heap.insert(value);
        indexMap.put(value, size);
        size++;
        heapifyUp();
    }

    public void remove(Evento value) {
        Integer index = indexMap.get(value);
        if (index == null) {
            throw new IllegalArgumentException("Value not found in heap");
        }

        heap.set(index, heap.get(size - 1));
        indexMap.put(heap.get(size - 1), index);
        indexMap.remove(value);
        size--;
        heapifyDown();
    }

    public Evento extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        Evento min = heap.get(0);
        heap.set(0, heap.get(size - 1));
        indexMap.put(heap.get(size - 1), 0);
        indexMap.remove(min);
        size--;
        heapifyDown();

        return min;
    }

    public Evento peekMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
