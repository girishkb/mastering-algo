package coursera.week2;

public class QuickSelect {

    public int KthSmallest(int[] arr, int k){
        int lo = 0;
        int hi = arr.length-1;

        while (hi > lo) {
            int  j = partition(arr,lo,hi);
            if (j < k) lo = j+1;
            else if (j > k) hi = j-1;
            else return arr[k];
         }
        return arr[k];
    }

    public int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi+1;

        while(true){
            while (arr[++i] <= arr[lo]){
                if(i == hi) break;
            }
            while(arr[lo] < arr[--j]){
                if(j == lo) break;
            }
            if( i>=j ) break;
            swap(arr, i,j);
        }
        swap(arr, lo,j);
        return j;
    }

    public void swap(int[]a , int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a= {5,3,1,20,40,31,15,8,4};
        QuickSelect quickSelect = new QuickSelect();
        System.out.println("KthSmallest ::: " + quickSelect.KthSmallest(a,6));
    }
}
