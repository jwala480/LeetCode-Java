/*
 * Problem: 18. 4Sum
 * Difficulty: Medium
 *
 * Approach:
 * 1. Sort the array to efficiently use the two-pointer technique.
 * 2. Fix the first element using index `i`.
 *    - Skip duplicate values to avoid repeated quadruplets.
 * 3. Fix the second element using index `j`.
 *    - Skip duplicate values for the second element as well.
 * 4. Use two pointers:
 *    - `left = j + 1`
 *    - `right = n - 1`
 * 5. Calculate the sum of the four elements.
 *    - If the sum equals the target:
 *        - Add the quadruplet to the result.
 *        - Move both pointers inward.
 *        - Skip duplicate values for `left` and `right`.
 *    - If the sum is smaller than the target:
 *        - Move `left` forward to increase the sum.
 *    - If the sum is greater than the target:
 *        - Move `right` backward to decrease the sum.
 * 6. Use `long` while calculating the sum to prevent integer overflow.
 *
 * Time Complexity: O(n³)
 * Space Complexity: O(1) (excluding the output list)
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j = i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left<right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                    else if (sum<target){
                            left++;
                        }
                    else{
                        right--;
                    }

                    }

                }
            }
        
        return result;
        
    }
}
