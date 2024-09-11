package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;

import java.util.Random;

public class HashSetFavoritos{

    private class Node{

        public long data;
        public Node next;

    }

    private Node[] table;
    private int size, a, b;
    private double loadFactor;

    public HashSetFavoritos(){
        table = new Node[16];
        size = 0;
        loadFactor = 0.75;
        a = Math.abs(new Random().nextInt());
        b = Math.abs(new Random().nextInt());
    }

    public HashSetFavoritos(int initialCapacity, double loadFactor){
        table = new Node[initialCapacity];
        size = 0;
        this.loadFactor = loadFactor;
        a = Math.abs(new Random().nextInt());
        b = Math.abs(new Random().nextInt());
    }

    private int polyHash(long num, int a, int b, int p){

        return (int)((num*a + b) % p);

    }

    private int h(Long num){

        int p = nearestPrime((int)Math.pow(10,num.toString().length()));
        int a = this.a / p;
        int b = this.b / p;

        return polyHash(num, a, b, p) % table.length;

    }


    /*
    private int h(Long num){
        return num.toString().hashCode() % table.length;
    }
    */

    private boolean isPrime(int n) {

        if (n%2==0)
            return false;

        for(int i=3;i*i<=n;i+=2)
            if(n%i==0)
                return false;

        return true;
    }

    private int nearestPrime(int n){

        int prime = n;

        while(!isPrime(prime))
            prime++;

        return prime;

    }

    public void put(long key){

        if(hasKey(key)){
            System.out.println("This key is already set");
            return;
        }

        if(((double)size)/table.length > loadFactor)
            reHash();

        int hash = h(key);

        Node node = table[hash];

        if(node == null){
            node = new Node();
            node.data = key;
            table[hash] = node;
        } else {

            Node n = node;

            while(n.next != null)
                n = n.next;

            n.next = new Node();
            n.next.data = key;

        }

        size++;

    }

    public boolean hasKey(long key){

        Node node = table[h(key)];

        if(node == null)
            return false;
        else{

            Node n = node;

            do{

                if(key == n.data)
                    return true;

                n = n.next;

            }while(n != null);

            return false;

        }

    }

    private void reHash(){

        size = 0;

        a = Math.abs(new Random().nextInt());
        b = Math.abs(new Random().nextInt());

        Node[] oldTable = table;

        table = new Node[table.length * 2];

        for(int i = 0; i < oldTable.length; i++){

            Node node = oldTable[i];

            if(node != null){

                put(node.data);

                while(node.next != null){

                    node = node.next;

                    put(node.data);

                }

            }

        }

    }

    public void remove(long key){

        if(!hasKey(key)){
            System.out.println("Key is no in the hashtable");
            return;
        }

        int hash = h(key);

        Node n = table[hash];

        if(n.data == key)
            table[hash] = n.next;
        else {

            Node nextN = n.next;

            while(!(nextN.data == key)){
                n = n.next;
                nextN = nextN.next;
            }

            n.next = nextN.next;

        }

        size--;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

}