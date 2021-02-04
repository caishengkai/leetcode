package com.csk.leetcode;

/**
 * @description: 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 
 * @author: caishengkai
 * @date: 2021-02-04 10:55
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        for (int l = 0; l < k; l++) {
            sum += nums[l];
        }
        int max = sum;
        for (int i = k; i < length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum, max);
        }
        return max*1.0 / k;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        System.out.println(solution643.findMaxAverage(new int[]{-1}, 1));
    }
}
