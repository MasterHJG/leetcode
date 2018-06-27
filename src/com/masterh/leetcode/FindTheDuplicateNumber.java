package com.masterh.leetcode;

/**
 * 题目描述
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 */
public class FindTheDuplicateNumber {
    /**
     * 题目中：nums包含n+1个元素，每个元素都是在[1,n]之间
     * 先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同，
     * 这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，
     * 当这两个下标相遇时，就是环的起点，也就是重复的数。
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        if(slow==fast)
            return slow;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int find=0;
        while(find!=slow){
            slow=nums[slow];
            find=nums[find];
        }
        return find;

    }

    /**
     * 如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。
     * 下次找的时候，还是找一半。
     * @param nums
     * @return
     */
    public int findDuplicate_1(int[] nums){
        int min=1;
        int max=nums.length-1;
        while(min<=max){
            int mid=(min+max)/2;
            int cnt=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid)
                    cnt++;
            }
            if(cnt>mid)
                max=mid-1;
            else
                min=mid+1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,5,4,3,3};
        System.out.println(new FindTheDuplicateNumber().findDuplicate_1(nums));
    }
}
