package com.csk.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第 N 个泰波那契数
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 * 
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 *
 * @author: caishengkai
 * @date: 2020-12-31 16:27
 */
public class Solution1137 {

    static  Map<Integer, Integer> map = new HashMap<>();
    static int[] nums = new int[38];

    /**
     * 带记忆的简单递归，map存储
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);

        map.put(n, result);

        return result;
    }

    /**
     * 带记忆的简单递归，数组存储
     * @param n
     * @return
     */
    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        if (nums[n] != 0) {
            return nums[n];
        }

        nums[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);

        return nums[n];
    }

    public static void main(String[] args) {
        Solution1137 solution = new Solution1137();
        System.out.println(solution.tribonacci2(35));
    }
}
