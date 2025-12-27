package coursera.week1;

/*
Search in a bitonic array. An array is bitonic if it comprises an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of
n
nn distinct integer values, determines whether a given integer is in the array.

Standard version: Use
∼ 3lgn
∼3lgn\sim, 3, \lg, n compares in the worst case.

Signing bonus: Use
∼ 2 lgn n compares in the worst case (and prove that no algorithm can guarantee to perform fewer than
∼2 lgn n compares in the worst case).
*/

public class SearchBitonicArray {


   public static int solve3lgn(int []arr, int target) {
       int peak = findPeak(arr);
       int  idx  = binarySearchAscending(arr,0,arr.length-1,target);
       if (idx != -1 ) return  idx;
       return  binarySearchDescending(arr,0,arr.length-1,target);

   }

   public static  int solve2lgn(int[] arr, int target) {
       int  lo = 0, hi = arr.length -1;
       while (lo < hi) {
           int mid = lo +(hi-lo)/2;
           if(target == arr[mid]) return  mid;
           boolean isIncreasing  =   arr[mid] < arr[mid+1];
           if (isIncreasing){
               if (target < arr[ mid]) hi = mid -1;
               else lo = mid +1;
           } else {
               if (target < arr[ mid]) lo = mid +1;
               else  hi = mid -1;
           }
       }
       return  -1;
   }


   public static int solve2lgnBinarySearch(int arr[], int target, int lo, int hi) {
       if ( lo > hi) return  -1;

       int mid = lo +  (hi- lo)/2;
       if (target == arr[mid]) return  mid;

       if ( mid == 0){
           if (arr[1] < arr[0]) return  -1;
       }
       if( mid == arr.length-1){
           if(arr[mid-1] < arr[mid]) return  -1;
       }

       boolean isIncreasing =  (mid+1 <= hi) && (arr[mid] < arr[mid+1]) ;

       if (target > arr[mid]) {
           if (isIncreasing) {
               return solve2lgnBinarySearch(arr,target,mid+1, hi);
           }else {
               return solve2lgnBinarySearch(arr,target,lo, mid-1);
           }
       }
       if (target < arr[mid]) {
           if (isIncreasing) {
               int leftIdx = solve2lgnBinarySearch(arr,target,lo, mid-1);
               if( leftIdx != -1) return  leftIdx;
               return solve2lgnBinarySearch(arr,target, mid+1, hi);
           } else {
                int rightIdx = solve2lgnBinarySearch(arr,target,mid+1, hi);
                 if (rightIdx != -1) return  rightIdx;
                 return solve2lgnBinarySearch(arr,target,lo, mid-1);
           }
       }

       return  -1;
   }

   public static int findPeak(int [] arr) {
       int lo=0, hi = arr.length-1;
       while(lo < hi) {
           int mid = lo +(hi-lo)/2;
           if(arr[mid] < arr[mid+1])  lo = mid +1;
           else hi = mid;
       }
       return  lo;
   }


   public static int binarySearchAscending(int[] arr, int lo, int hi, int target) {
       while( lo <= hi) {
           int mid = lo + (hi-lo)/2;
           if( arr[mid] == target) return  mid;
           else if(target < arr[mid])  hi = mid -1;
           else lo = mid +1;
       }
       return -1;
   }


    public static int binarySearchDescending(int[] arr, int lo, int hi, int target) {
        while( lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if( arr[mid] == target) return  mid;
            else if(target > arr[mid])  hi = mid -1;
            else lo = mid +1;
        }
        return -1;
    }


     /*This method supports binary search of sort array which is either increasing or decreasing direction*/
    public static int binarySearch(int[] arr, int lo, int hi, int target, boolean increasing) {
       while (lo <= hi) {
           int mid = lo + (hi-lo)/2;
           if( arr[mid] == target) return  mid;
           else if( target < arr[mid] == increasing) {
               hi = mid -1;
           }
           else {
               lo = mid +1;
           }
       }
       return  -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,8,12,14,13,10,4,2};
        int target = 1;
        int result = solve3lgn(arr,target);
        System.out.println("Result index::: " + result );

        int resultOptimal = solve3lgn(arr,target);
        System.out.println("OptimalResult index::: " + resultOptimal );
    }
}
