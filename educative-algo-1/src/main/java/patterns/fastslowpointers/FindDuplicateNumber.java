package patterns.fastslowpointers;

public class FindDuplicateNumber {

    public  int findDuplicate(int[] nums){

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
    public static void main(String[] args) {

        FindDuplicateNumber sol = new FindDuplicateNumber();
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in [1,3,4,2,2]: " + sol.findDuplicate(nums1)); // 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in [3,1,3,4,2]: " + sol.findDuplicate(nums2)); // 3

        int[] nums3 = {2, 2, 2, 2, 2};
        System.out.println("Duplicate in [2,2,2,2,2]: " + sol.findDuplicate(nums3)); // 2


    }
}
