package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;

import com.example.datastructureproject_groupb.entidades.evento.Evento;

public class MinHeapCostoEventos {

    private DynamicUnsortedList<Evento> heap;
    private int size;

    public MinHeapCostoEventos() {
        this.size = 0;
        this.heap = new DynamicUnsortedList<Evento>();
    }

    public MinHeapCostoEventos(DynamicUnsortedList<Evento> arr){
        heap = arr;
        size = arr.size;

        for(int i = (arr.size - 1) / 2; i > -1; i--)
            siftDown(i);

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
        while (hasParent(index) && heap.get(index).getCostoEvento() < heap.get(getParentIndex(index)).getCostoEvento()) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void siftDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap.get(getRightChildIndex(index)).getCostoEvento() < heap.get(smallerChildIndex).getCostoEvento()) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap.get(index).getCostoEvento() < heap.get(smallerChildIndex).getCostoEvento()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    public void insert(Evento evento) {
        heap.insert(evento);
        size++;
        siftUp(size - 1);
    }

    public void remove(Evento evento) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap.get(i) == evento) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Value not found in heap");
        }

        heap.set(index, heap.get(size - 1));
        size--;
        siftDown(index);
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

    public DynamicUnsortedList<Evento> heapSort(){

        for(int i = size - 1; i > 0; i--){

            swap(0, i);
            size--;
            siftDown(0);

        }

        return heap;

    }


}
