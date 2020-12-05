package com.csk.leetcode;

/**
 * @description: 计数质数
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * @author: caishengkai
 * @date: 2020-12-04 09:14
 */
public class Solution204 {

    public int countPrimes(int n) {
        int sum = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                sum++;
                //把当前数的所有倍数置为非质数，最后剩下的就都是质数
                for (int j = i+i; j < n; j=j+i) {
                    signs[j] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution204 solution = new Solution204();
        System.out.println(solution.countPrimes(10));
    }
}
