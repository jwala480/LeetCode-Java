/*
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Approach:
 * 1. Use Binary Search to locate the minimum element in the rotated sorted array.
 * 2. Initialize two pointers:
 *    - `low` at the beginning of the array.
 *    - `high` at the end of the array.
 * 3. While `low < high`, calculate the middle index (`mid`).
 * 4. Compare `nums[mid]` with `nums[high]`:
 *    - If `nums[mid] > nums[high]`, the minimum element lies in the right half
 *      because the rotation point is after `mid`.
 *      - Move `low` to `mid + 1`.
 *    - Otherwise, the minimum element is at `mid` or in the left half.
 *      - Move `high` to `mid`.
 * 5. Continue narrowing the search space until `low == high`.
 * 6. At this point, both pointers point to the smallest element in the array.
 * 7. Return `nums[low]` as the minimum value.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
