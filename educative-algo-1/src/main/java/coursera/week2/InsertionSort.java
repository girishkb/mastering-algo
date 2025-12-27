package coursera.week2;

import java.util.Arrays;

public class InsertionSort {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }
                else break;
            }
        }
    }

    public boolean less(Comparable v, Comparable w) {
        return  v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer [] arr = {20,10,1,6,2,44,11,22};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
