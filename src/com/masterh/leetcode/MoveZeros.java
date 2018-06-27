package com.masterh.leetcode;

import java.util.Arrays;

public class MoveZeros {
    /**
     * 用j来维护当前0元素的位置(index)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }

    public void moveZeros_1(int[] nums){
        int count=0; //连续0的个数
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                count++;
            }
            else if(count>0) {
                int temp=nums[i-count];
                nums[i-count]=nums[i];
                nums[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,1,2,0,5,6};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
