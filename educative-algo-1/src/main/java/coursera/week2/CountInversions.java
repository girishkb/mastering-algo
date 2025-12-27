package coursera.week2;

public class CountInversions {
    int [] aux ;

    public int sort(int[] a) {
        aux = new int[a.length];
        return sort(a,aux,0,a.length-1);
    }
    public int sort(int[] a,  int[] aux, int lo , int hi){
        if( hi<=lo )return 0;
        int mid = lo + (hi-lo)/2;
        int countInversions = 0;
        countInversions += sort(a,aux,lo,mid);
        countInversions += sort(a,aux,mid+1,hi);
        countInversions += merge(a,aux,lo,hi,mid);
        return countInversions;
    }
    public int merge(int[] a,  int[] aux, int lo , int hi, int mid){
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j= mid+1;
        int countInversions = 0;
        for (int k = lo; k<=hi;k++) {
            if(i>mid) a[k] = aux[j++];
            if(j>hi) a[k] = aux[i++];
            else if(aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
                countInversions+=(mid-i+1);
            }
        }
        return countInversions;
    }

    public static void main(String[] args) {

        int[] arr = {2,4,1,3,5};
        CountInversions ci = new CountInversions();
        System.out.println("Total inversions ::: " + ci.sort(arr));
    }
}
