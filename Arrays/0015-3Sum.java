/*
 * Problem: 15. 3Sum
 * Difficulty: Medium
 *
 * Approach:
 * 1. Sort the array to enable the two-pointer technique.
 * 2. Traverse the array and fix one element at a time.
 * 3. Skip duplicate elements to avoid repeated triplets.
 * 4. Use two pointers (left and right) to find two numbers
 *    whose sum with the fixed element equals zero.
 * 5. If the sum is:
 *    - Equal to 0: Add the triplet to the result and move both
 *      pointers while skipping duplicates.
 *    - Less than 0: Move the left pointer to increase the sum.
 *    - Greater than 0: Move the right pointer to decrease the sum.
 * 6. Continue until all unique triplets are found.
 *
 * Time Complexity: O(n²)
 *   - Sorting takes O(n log n)
 *   - Two-pointer traversal takes O(n²)
 *
 * Space Complexity: O(1)
 *   - Excluding the space used for storing the output list.
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix one number
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Use two pointers
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    result.add(triplet);

                    // Move both pointers
                    left++;
                    right--;

                    // Skip duplicate values for left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values for right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    // Need a bigger sum
                    left++;

                } else {
                    // Need a smaller sum
                    right--;
                }
            }
        }

        return result;
    }
}
