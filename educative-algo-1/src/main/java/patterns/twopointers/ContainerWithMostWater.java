package patterns.twopointers;

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.


* */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
             int width  = right - left;

             int currentHeight = Math.min(height[left],height[right]);

             int currentArea =  width* currentHeight;
             maxArea = Math.max(maxArea, currentArea);

             if (height[left] < height[right]) {
                 left ++;
             }else {
                 right --;
             }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        System.out.println("Array [1,8,6,2,5,4,8,3,7],  Result :: " + cw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
