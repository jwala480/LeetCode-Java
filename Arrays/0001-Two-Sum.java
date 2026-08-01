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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i=0; i < nums.length; i++){
            int complement = target - nums[i];
            if (sum.containsKey(complement))
                return new int[] {sum.get(complement), i};

            sum.put(nums[i], i);
        }
        return  new int[]{};
    
        }
}



