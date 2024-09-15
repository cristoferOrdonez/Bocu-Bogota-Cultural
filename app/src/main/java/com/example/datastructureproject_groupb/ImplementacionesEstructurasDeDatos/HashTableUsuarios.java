package com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos;

import java.util.Random;

public class HashTableUsuarios{

    private class Set{

        public String key;
        public String value;

        public Set(String key, String value){

            this.key = key;
            this.value = value;

        }

    }

    private class Node{

        public Set data;
        public Node next;

    }

    private Node[] table;
    private int size, x;
    private double loadFactor;

    public HashTableUsuarios(){
        table = new Node[16];
        size = 0;
        loadFactor = 0.75;
        x = Math.abs(new Random().nextInt());
    }

    public HashTableUsuarios(int initialCapacity, double loadFactor){
        table = new Node[initialCapacity];
        size = 0;
        this.loadFactor = loadFactor;
        x = Math.abs(new Random().nextInt());
    }

    private int polyHash(String str, int x, int p){

        int hash = 0;

        long xPow = (int) Math.pow(x, str.length());

        for(int i = str.length() - 1; i > -1; i--){

            hash += (str.charAt(i)*xPow)%p;

            xPow /= x;

        }

        return hash;

    }


    /*private int h(String str){

        int p = nearestPrime((int)Math.pow(10, str.length()));
        int x = this.x / p;

        return polyHash(str, x, p) % table.length;

    }

     */


/*
    private int h(String str){
        return str.hashCode() % table.length;
    }*/


    private int h(String str){
        return (str.hashCode() & 0x7fffffff) % table.length;
    }



    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n%2==0)
            return false;

        for(int i=3;i*i<=n;i+=2)
            if(n%i==0)
                return false;

        return true;
    }

    private int nearestPrime(int n){
        if (n <= 1) return 2;
        int prime = n;

        while(!isPrime(prime))
            prime++;

        return prime;

    }

    /*public void put(String key, String value){

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
            node.data = new Set(key, value);
            table[hash] = node;
        } else {

            System.out.println("Colisión");

            Node n = node;

            while(n.next != null)
                n = n.next;

            n.next = new Node();
            n.next.data = new Set(key, value);

        }

        size++;

    }*/

    //put versión 2
    public void put(String key, String value) {
        if (((double) size) / table.length > loadFactor) {
            reHash();
        }

        int hash = h(key);
        Node node = table[hash];

        while (node != null) {
            if (key.equalsIgnoreCase(node.data.key)) {
                node.data.value = value;
                return;
            }
            node = node.next;
        }

        Node newNode = new Node();
        newNode.data = new Set(key, value);
        newNode.next = table[hash];
        table[hash] = newNode;
        size++;
    }

    /*public boolean hasKey(String key){

        Node node = table[h(key)];

        if(node == null)
            return false;
        else{

            Node n = node;

            do{

                if(key.equalsIgnoreCase(n.data.key))
                    return true;

                n = n.next;

            }while(n != null);

            return false;

        }

    }*/
    //haskey versión2
    public boolean hasKey(String key) {
        int hash = h(key);
        Node node = table[hash];

        while (node != null) {
            if (key.equalsIgnoreCase(node.data.key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public String get(String key){

        Node node = table[h(key)];

        if(node == null)
            return null;
        else{

            Node n = node;

            do{

                if(key.equalsIgnoreCase(n.data.key))
                    return n.data.value;

                n = n.next;

            }while(n != null);

            return null;

        }

    }

    private void reHash(){

        size = 0;

        x = Math.abs(new Random().nextInt());

        Node[] oldTable = table;

        table = new Node[table.length * 2];

        for(int i = 0; i < oldTable.length; i++){

            Node node = oldTable[i];

            if(node != null){

                put(node.data.key, node.data.value);

                while(node.next != null){

                    node = node.next;

                    put(node.data.key, node.data.value);

                }

            }

        }

    }

    public void remove(String key){

        if(!hasKey(key)){
            System.out.println("Key is no in the hashtable");
            return;
        }

        int hash = h(key);

        Node n = table[hash];

        if(n.data.key.equalsIgnoreCase(key))
            table[hash] = n.next;
        else {

            Node nextN = n.next;

            while(!nextN.data.key.equalsIgnoreCase(key)){
                n = n.next;
                nextN = nextN.next;
            }

            n.next = nextN.next;

        }

    }

}