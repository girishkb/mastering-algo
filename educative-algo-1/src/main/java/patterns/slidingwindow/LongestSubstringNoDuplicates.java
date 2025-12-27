package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
*
* Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 */
public class LongestSubstringNoDuplicates {

    public int lengthOfLongestSubstring(String s){

        Map<Character,Integer> characterToIndex = new HashMap<>();
        int maxLength = 0;

        for (int left=0,right=0; right <s.length(); right++){
            Character c =  s.charAt(right);
            if(characterToIndex.containsKey(c)){
                int previousOccurrenceIdx = characterToIndex.get(c);
                left =  Math.max(left,previousOccurrenceIdx+1);
            }
            characterToIndex.put(c,right);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringNoDuplicates t = new LongestSubstringNoDuplicates();
        String s1 = "abcabcbb";
        System.out.println(t.lengthOfLongestSubstring(s1));

        System.out.println("\nInput: \"bbbbb\"");
        System.out.println("Output: " + t.lengthOfLongestSubstring("bbbbb")); // 1 ("b")

    }
}
