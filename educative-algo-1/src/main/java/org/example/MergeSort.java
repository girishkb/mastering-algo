package org.example;

import java.util.Arrays;

public class MergeSort {

    private int[] aux;
    public void sort(int[] arr){
        aux = new int[arr.length];
        mergeSort(arr,0,arr.length-1);
    }
    private void mergeSort(int[] arr, int lo, int hi){
        if (hi<=lo) { return;}
            int mid = lo + (hi - lo)/2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr,lo,mid,hi);
    }
    private void merge(int[] arr, int left, int mid, int right){
        for(int i= left;i<=right;i++){
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid+1;
        for (int k = left; k <= right; k++){
            if (i > mid) arr[k] = aux[j++];
            else if (j > right) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{21,45,11,1,13,55,90,32};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*public static void merge(int[] arr, int start, int mid, int end){
        int sz1 = mid - start+1;
        int sz2 = end - mid;
        int[] L = new int[sz1];
        int[] R = new int[sz2];

        for(int i = 0; i < sz1; i++){
            L[i] = arr[start+i];
        }
        for(int i = 0; i < sz2; i++){
            R[i] = arr[mid+i+1];
        }

        int i=0,j=0,k=start;
        while(i < sz1 && j < sz2){
            if (L[i] <= R[j]){
                arr[k++] = L[i++];
            }else {
                arr[k++] = R[j++];
            }
        }
        while (i < sz1){
            arr[k++] = L[i++];
        }
        while (j < sz2){
            arr[k++] = R[j++];
        }
    }
    public static void sort(int[] arr, int start, int end){
        if(start >= end) {
            return;
        }
        int mid = (start + end)/2;
        sort(arr,start,mid);
        sort(arr, mid+1, end);
        merge(arr,start,mid,end);
    }*/



}
