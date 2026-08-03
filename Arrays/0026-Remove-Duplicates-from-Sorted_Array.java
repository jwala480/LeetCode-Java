/*
 * Problem: 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 *
 * Approach:
 * 1. Use the two-pointer technique on the sorted array.
 * 2. Initialize pointer `i` at the first element to track the position of the last unique element.
 * 3. Traverse the array using pointer `j` starting from index 1.
 * 4. If `nums[j]` is different from `nums[i]`:
 *    - Increment `i`.
 *    - Swap `nums[i]` and `nums[j]` to place the new unique element in its correct position.
 * 5. Continue until the entire array is processed.
 * 6. The first `i + 1` elements of the array contain all unique elements in sorted order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return i + 1;
    }
}
