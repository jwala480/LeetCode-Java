/*
 * Problem: 14. Longest Common Prefix
 * Difficulty: Easy
 *
 * Approach:
 * 1. Check if the input array is null or empty.
 * 2. Use the first string as the reference.
 * 3. Traverse each character of the first string.
 * 4. Compare the current character with the corresponding character
 *    in every other string.
 * 5. If a mismatch is found or any string ends,
 *    return the prefix up to the current index.
 * 6. If all characters match, return the first string.
 *
 * Time Complexity: O(n × m)
 *   - n = Number of strings
 *   - m = Length of the shortest string (or common prefix length)
 *
 * Space Complexity: O(1)
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null||strs.length==0){
            return "";
        }
        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j =0;j<strs.length;j++){
                if (i>=strs[j].length() || strs[j].charAt(i)!=ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
