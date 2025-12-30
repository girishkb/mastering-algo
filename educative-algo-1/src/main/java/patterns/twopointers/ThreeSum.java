package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
*  and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

* */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers){
        if (numbers == null || numbers.length <3) return null;
        Arrays.sort(numbers);

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numbers.length-2; i++) {

            int left =i+1, right =numbers.length-1;

            // Skip duplicate elements for first element.
            if(i>0 && numbers[i]== numbers[i-1]) continue;

            // Since the array is sorted. if the value >0, the sum can never be 0 again.
            if(numbers[i] > 0) break;;

            int target = -numbers[i];
            while (left< right) {
                int sum= numbers[left] + numbers[right];

                if(target == sum) {
                    results.add(Arrays.asList(numbers[i],numbers[left],numbers[right]));

                    // Skip duplicates for left pointer
                    while (left < right && numbers[left] == numbers[left+1]) left++;

                    // Skip duplicates for right pointer
                    while (left < right && numbers[right] == numbers[right-1]) right--;

                    left ++;
                    right --;
                }else if(sum < target) {
                    left++;
                }
                else  {
                    right--;
                }

            }

        }
        return results;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println("Arr: [-1,0,1,2,-1,-4]  Result :: " + threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
