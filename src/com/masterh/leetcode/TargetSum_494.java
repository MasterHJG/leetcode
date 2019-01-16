package com.masterh.leetcode;

public class TargetSum_494 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        help(nums, S, 0, 0);
        return count;
    }

    private void help(int[] nums, int s, int sum, int index) {
        if (index == nums.length) {
            if (sum == s)
                count++;
        } else {
            help(nums, s, sum + nums[index], index + 1);
            help(nums, s, sum - nums[index], index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new TargetSum_494().findTargetSumWays(nums, 3));
    }
}
