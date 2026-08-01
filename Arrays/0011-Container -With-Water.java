/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 *
 * Approach:
 * 1. Use a HashMap to store each number along with its index.
 * 2. Traverse the array once.
 * 3. For each element, calculate its complement:
 *        complement = target - nums[i]
 * 4. Check if the complement already exists in the HashMap.
 *    - If it exists, return the stored index and the current index.
 *    - Otherwise, store the current number and its index in the HashMap.
 * 5. This ensures we find the pair in a single traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int width = right - left;
            int currentHeight = Math.min(height[left],height[right]);
            int area = width * currentHeight;
            maxArea  = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
        
    }
}
