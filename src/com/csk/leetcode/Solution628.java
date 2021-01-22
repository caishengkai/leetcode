package com.csk.leetcode;

import java.util.Arrays;

/**
 * @description: 三个数的最大乘积
 *
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * 
 *
 * 提示：
 *
 * 3 <= nums.length <=104
 * -1000 <= nums[i] <= 1000
 *
 * @author: caishengkai
 * @date: 2021-01-22 09:47
 */
public class Solution628 {

    /**
     * 全是正数或者全是负数，取最大的3个相乘即为最大值
     * 有正数有负数， 可能是最大3个相乘，也可能是2个最小负数*最大正数
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length-1]*nums[length-2]*nums[length-3], nums[0]*nums[1]*nums[length-1]);
    }

    /**
     * 直接找出最大、第二大、第三大、最小、第二小的值
     * 只需遍历一次
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1);
    }

    public static void main(String[] args) {
        Solution628 solution = new Solution628();
        int result = solution.maximumProduct2(new int[]{-1000,-1000,1000});
        System.out.println(result);
    }
}
