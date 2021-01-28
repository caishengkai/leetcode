package com.csk.leetcode;

import java.util.Arrays;

/**
 * @description: 寻找数组的中心索引
 * 给定一个整数类型的数组nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * 
 *
 * 说明：
 *
 * nums 的长度范围为[0, 10000]。
 * 任何一个nums[i] 将会是一个范围在[-1000, 1000]的整数。
 *
 * @author: caishengkai
 * @date: 2021-01-28 09:43
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * 官方简洁解答
     * @param nums
     * @return
     */
    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution724 solution = new Solution724();
        System.out.println(solution.pivotIndex2(new int[]{-1,-1,-1,0,1,1}));
    }
}
