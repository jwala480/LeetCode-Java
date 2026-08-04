/*
 * Problem: 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Approach:
 * 1. Apply Binary Search on the rotated sorted array.
 * 2. Initialize two pointers:
 *    - `low` at the beginning of the array.
 *    - `high` at the end of the array.
 * 3. Find the middle element (`mid`) in each iteration.
 * 4. If `nums[mid]` equals the target, return `mid`.
 * 5. Determine which half of the array is sorted:
 *    - If `nums[low] <= nums[mid]`, the left half is sorted.
 *      - Check if the target lies within this range.
 *      - If yes, search the left half.
 *      - Otherwise, search the right half.
 *    - Otherwise, the right half is sorted.
 *      - Check if the target lies within this range.
 *      - If yes, search the right half.
 *      - Otherwise, search the left half.
 * 6. Repeat until the target is found or the search space becomes empty.
 * 7. Return `-1` if the target is not present.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }
}
