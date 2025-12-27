package coursera.week1;

import java.util.Arrays;

public class ThreeSum {

    public static void threeSum(int[] arr){
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i+1;
            int right = arr.length-1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    System.out.println(arr[i] + ", " + arr[left] + ", "+ arr[right]);
                    left++ ;
                    right --;
                } else if ( sum >0 ) {
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {-4,-1,1,0,2,3};
        threeSum(arr);
    }
}
