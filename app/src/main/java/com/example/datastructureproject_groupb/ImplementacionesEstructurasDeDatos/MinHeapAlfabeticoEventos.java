package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;

import com.example.datastructureproject_groupb.entidades.evento.Evento;

public class MinHeapAlfabeticoEventos{
    private DynamicUnsortedList<Evento> heap;
    private int size;

    public MinHeapAlfabeticoEventos() {
        this.size = 0;
        this.heap = new DynamicUnsortedList<>();
    }
    public MinHeapAlfabeticoEventos(DynamicUnsortedList<Evento> arr){
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
    }

    private void siftUp(int index) {
        while (hasParent(index) &&
                heap.get(index).getNombreEvento().compareToIgnoreCase(heap.get(getParentIndex(index)).getNombreEvento()) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void siftDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) &&
                heap.get(getRightChildIndex(index)).getNombreEvento().compareToIgnoreCase(heap.get(smallerChildIndex).getNombreEvento()) < 0) {
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
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        Evento min = heap.get(0);
        heap.set(0, heap.get(size - 1));
        size--;
        siftDown(0);

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
