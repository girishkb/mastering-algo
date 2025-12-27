package coursera.week2;

import javax.swing.*;

/*
* Nuts and Bolts Problem Summary

You have:

n nuts

n bolts

Each nut matches exactly one bolt.

You can only compare a nut to a bolt (to see whether nut < bolt, nut = bolt, or nut > bolt).

You cannot:

Compare two nuts directly.

Compare two bolts directly.

Goal:
👉 Find all matching nut–bolt pairs using O(n log n) comparisons.
* */
public class NutsAndBolts {

    public static class Nut implements  Comparable<Bolt> {
        private final int size ;

        public Nut(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(Bolt o) {
            if (this.size == o.size) return 0;

            return this.size < o.size? -1:1;
        }

        public static Nut[] buildNuts(int n) {
            Nut[] nuts= new Nut[n] ;
            for (int i = 0; i <n ; i++) {
                nuts[i] = new Nut(i);
                
            }
            return nuts;
        }

    }

    public static class Bolt implements Comparable<Nut>{

        private final int size ;

        public Bolt(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(Nut o) {
            if (this.size == o.size) return 0;
            return this.size < o.size? -1:1;
        }

        public static Bolt[] buildBolts(int n) {
            Bolt[] bolts= new Bolt[n] ;
            for (int i = 0; i <n ; i++) {
                bolts[i] = new Bolt(i);

            }
            return bolts;
        }

    }


    public void match(Nut[] Nuts, Bolt[] Bolts){
        if(Nuts.length != Bolts.length) {
            throw new IllegalArgumentException("Bolts and Nuts length should be same");
        }
        quickSort(Nuts, Bolts,0, Nuts.length-1);
    }

    public void quickSort(Nut[] Nuts, Bolt[] Bolts, int low, int high) {
        if (low >= high) return;

        Nut pivot = Nuts[low];
    }

    public int partition(Bolt[] Bolts, int low, int high, Nut pivot){
        int i = low, j = high+1;

        while (i < j) {
           int cmp = Bolts[i].compareTo(pivot);
           if (cmp < 0) {
           }
        }
        return -1;
    }

    public void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

    }
}
