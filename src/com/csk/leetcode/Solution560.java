package com.csk.leetcode;

/**
 * @description: 区域和检索 - 数组不可变
 * @author: caishengkai
 * @time: 2022/3/8 21:27
 */
public class Solution560 {

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len+1];
        for (int i = 0; i < len; i++) {
            temp[i+1] = temp[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (temp[j+1]-temp[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1,-1,1}, 0));
    }

}