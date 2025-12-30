package patterns.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {

    public int longest(int[] arr, int k) {

        int[] result = {0,-1,-1}; // maxLength, start index, end index

        Map<Integer,Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0,-1);
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum+= arr[i];

            int targetCount = prefixSum -k ;
            if(prefixSumToIndex.containsKey(targetCount)) {
                int currLength =  i - prefixSumToIndex.get(targetCount);
                if (result[0] < currLength) {
                    result[0] = currLength;
                    result[1] = prefixSumToIndex.get(targetCount)==-1?0:prefixSumToIndex.get(targetCount);
                    result[2] = i;
                }
            }else{
                prefixSumToIndex.put(prefixSum,i);
            }
        }

        if (result[0] != 0) {
            int[] subArray = Arrays.copyOfRange(arr, result[1], result[2] + 1);
            System.out.println("LongestSubArray ::: " + Arrays.toString(subArray));
        }

        return  result[0];
    }

    public static void main(String[] args) {

        LongestSubArraySumK subArraySumK  = new LongestSubArraySumK();
//        int[] a1 = {10, 5, 2, 7, 1, -10};
//        int k1 = 15;
//
//        System.out.println("Array ::: " + Arrays.toString(a1) + " maxLength :: " + subArraySumK.longest(a1,k1));


        int[] a2 = {-5, 8, -14, 2, 4, 12};
        int k2 = -5;

        System.out.println("\n\nArray ::: " + Arrays.toString(a2) + " maxLength :: " + subArraySumK.longest(a2,k2));



        int[] a3 = {-10, -10, 20, 30};
        int k3 = 5;

        System.out.println("\n\nArray ::: " + Arrays.toString(a3) + " maxLength :: " + subArraySumK.longest(a3,k3));



    }
}
