package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
*Given two strings s and t of lengths m and n respectively,
* return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
* If there is no such substring, return the empty string "".
Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.


 * */
public class MinimumWindowSubstring {


    public String minimumWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character,Integer> targetFrequency = new HashMap<>();
        for (Character c : t.toCharArray()) {
            targetFrequency.put(c, targetFrequency.getOrDefault(c,0)+1);
        }

        int formedCount = 0;
        int requiredCount = targetFrequency.size();


        int left =0, right=0;
        // Track best window found so far: windowSize leftIndex, rightIndex
        int[] result = {-1,0,0};
        int minLen = Integer.MAX_VALUE;

        Map<Character,Integer> windowMap = new HashMap<>();
        while (right < s.length()) {
            Character c =  s.charAt(right);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);

            if(targetFrequency.containsKey(c) &&
                    targetFrequency.get(c).intValue() == windowMap.get(c).intValue()) {
                formedCount++;
            }

            while (formedCount == requiredCount && left <= right) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    result[0] = currentLen;
                    result[1] =left;
                    result[2] = right;
                }
                Character leftChar  = s.charAt(left);

                windowMap.put(leftChar,windowMap.get(leftChar) -1);

                if(targetFrequency.containsKey(leftChar) && windowMap.get(leftChar) < targetFrequency.get(leftChar)) {
                    formedCount--;
                }
                left++;
            }
            right++;
        }

        return  result[0] == -1? "" : s.substring(result[1], result[2]+1);
    }
    public static void main(String[] args) {

        MinimumWindowSubstring  sol  = new MinimumWindowSubstring();

        System.out.println("Input: s = \"ADOBECODEBANC\", t = \"ABC\"");
        System.out.println("Output: \"" + sol.minimumWindow("ADOBECODEBANC", "ABC") + "\""); // "BANC"

        // Example 2
        System.out.println("\nInput: s = \"a\", t = \"a\"");
        System.out.println("Output: \"" + sol.minimumWindow("a", "a") + "\""); // "a"

        // Example 3
        System.out.println("\nInput: s = \"a\", t = \"aa\"");
        System.out.println("Output: \"" + sol.minimumWindow("a", "aa") + "\""); // ""

        // Example 4: Duplicates in t
        System.out.println("\nInput: s = \"aab\", t = \"aab\"");
        System.out.println("Output: \"" + sol.minimumWindow("aab", "aab") + "\""); // "aab"


    }
}
