package com.csk.leetcode;

/**
 * @description: 斐波那契数
 * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 
 *
 * 提示：
 *
 * 0 <= n <= 30
 *
 * @author: caishengkai
 * @date: 2021-01-04 09:41
 */
public class Solution509 {

    private final int[] nums = new int[31];
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (nums[n] != 0) {
            return nums[n];
        }

        nums[n] = fib(n-1) + fib(n-2);

        return nums[n];
    }

    public static void main(String[] args) {
        Solution509 solution = new Solution509();
        System.out.println(solution.fib(30));
    }
}
