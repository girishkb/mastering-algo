package patterns.slidingwindow;

import java.util.Arrays;

public class MaximumSumSubarray {

    public int[] maxSum(int[] arr, int k ){
        int n  = arr.length;
        if(k > arr.length) return  new int[]{-1,-1};
        int windowSum = 0 ;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        int maxStartIndex = 0;
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i-k];
            if (windowSum > maxSum) {
                maxStartIndex = i-k+1;
                maxSum = windowSum;
            }
        }
        return  new int[]{maxSum, maxStartIndex};
    }
    public static void main(String[] args) {

        MaximumSumSubarray ms = new MaximumSumSubarray();
        int[] nums1 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k1 = 4;

        System.out.println("nums1:: " + Arrays.toString(nums1) + "  k::" + k1 + " Result :::" +  Arrays.toString(ms.maxSum(nums1,k1)));


        int[] nums2 = {-1, 2, 4, -3, 5, 2};
        int k2 = 3;

        System.out.println("nums1:: " + Arrays.toString(nums2) + "  k::" + k2 + " Result :::" +  Arrays.toString(ms.maxSum(nums2,k2)));


    }
}
