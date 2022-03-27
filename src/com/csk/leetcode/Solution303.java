package com.csk.leetcode;

/**
 * @description: 区域和检索 - 数组不可变
 * @author: caishengkai
 * @time: 2022/3/8 21:27
 */
public class Solution303 {


}

class NumArray {

    int[] temp;

    public NumArray(int[] nums) {
        temp = new int[nums.length+1];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return temp[right+1] - temp[left];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
