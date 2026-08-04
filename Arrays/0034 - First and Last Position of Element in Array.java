/*
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 *
 * Approach:
 * 1. Use Binary Search twice on the sorted array.
 * 2. In the first search, find the first occurrence of the target:
 *    - If the target is found, store its index.
 *    - Continue searching the left half to find an earlier occurrence.
 * 3. In the second search, find the last occurrence of the target:
 *    - If the target is found, store its index.
 *    - Continue searching the right half to find a later occurrence.
 * 4. If the target is not found, both searches return `-1`.
 * 5. Return an array containing the first and last positions of the target.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */ 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    private int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }
}
