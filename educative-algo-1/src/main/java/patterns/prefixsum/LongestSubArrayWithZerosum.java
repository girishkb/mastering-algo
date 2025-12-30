package patterns.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* Given an array arr[] consisting of both positive and negative integers, find the length of the longest subarray whose elements sum is zero.
A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
*
* */
public class LongestSubArrayWithZerosum {


    public int maxLength(int[] arr) {
        Objects.requireNonNull(arr,"Array cannot be null");

        Map<Integer,Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0,-1); // base case when subarray starts from 0th index

        int prefixSum = 0 ;
        int [] result ={0,-1,-1};  // Subarray  maxLength, start Index, end Index
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSumToIndex.containsKey(prefixSum)) {
                int firstOccurrence = prefixSumToIndex.get(prefixSum);
                int currLength =   i - firstOccurrence;
                if (result[0] < currLength) {
                    result[0] =  currLength;
                    result[2] = i;
                    result[1] = firstOccurrence+1;
                }
            } else{
                prefixSumToIndex.put(prefixSum,i);
            }
        }
        if(result[0] != 0) {
            int[] subArray = Arrays.copyOfRange(arr, result[1], result[2] + 1);
            System.out.println("LongestSubArray ::: " + Arrays.toString(subArray));
        }
        return  result[0];
    }

     public static void main(String[] args) {

        LongestSubArrayWithZerosum t = new LongestSubArrayWithZerosum();
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        System.out.println("Array: " + Arrays.toString(arr) + "  maxLength :: " + t.maxLength(arr));


         int[] arr1 = {1,2,3};
         System.out.println("\n\nArray: " + Arrays.toString(arr1) + "  maxLength :: " + t.maxLength(arr1));

         int[] arr2 = {1, 0, 3};
         System.out.println("\n\nArray: " + Arrays.toString(arr2) + "  maxLength :: " + t.maxLength(arr2));

     }
}
