/*
 * Problem: 4. Median of Two Sorted Arrays
 * Difficulty:Hard
 *
 * Approach:
 * 1. Create a new array to store the merged elements of both sorted arrays.
 * 2. Use the two-pointer technique to merge the arrays while maintaining sorted order.
 * 3. Copy any remaining elements from either array after one array is exhausted.
 * 4. Find the median of the merged array:
 *    - If the total length is odd, return the middle element.
 *    - If the total length is even, return the average of the two middle elements.
 *
 * Note:
 * - This approach is simple and easy to understand.
 * - However, it does not satisfy the follow-up requirement of O(log(m+n)) time,
 *   as it explicitly merges both arrays.
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }

        int len = result.length;

        if (len % 2 != 0) {
            return result[len / 2];
        } else {
            return (result[len / 2 - 1] + result[len / 2]) / 2.0;
        }
    }
}
