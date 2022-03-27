package com.csk.leetcode;

/**
 * @description:
 * @author: caishengkai
 * @time: 2022/3/7 21:11
 */
public class Solution26_2 {

    public static int removeDuplicates(int[] nums) {
        int j=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4}; // 输入数组
        int[] expectedNums = new int[]{0,1,2,3,4}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.print(nums[i] + " ");
        }

    }
}
