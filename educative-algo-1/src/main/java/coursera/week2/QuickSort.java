package coursera.week2;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] a) {
        sort(a,0,a.length-1);
    }

    public void sort(int[] a, int lo,int hi) {
        if( hi <= lo) return;
        int p = partition(a,lo,hi);
        sort(a,lo,p-1);
        sort(a,p+1,hi);
    }

    public int partition(int[]a,int lo,int hi){

        int i = lo;
        int j= hi;
        int pivot = a[lo];
        while (true){
            while (a[i]<= pivot){
                i++;
                if (i == hi) break;
            }
            while(a[j] > pivot) {
                j--;
                if (j == lo) break;
            }
            if( j <=i) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public void exch(int[]a , int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a= {5,3,1,20,40,31,15,8,4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
