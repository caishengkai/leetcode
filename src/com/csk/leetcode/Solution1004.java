package com.csk.leetcode;

/**
 * @description: 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组A，我们最多可以将K个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * 
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为0或1
 *
 * @author: caishengkai
 * @date: 2021-02-04 17:33
 */
public class Solution1004 {

    /**
     * 滑动窗口
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int x = 0;
        int length = A.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (A[j] == 1) {
                x++;
            }
            if (j - i + 1 > x + K) {
                if (A[i] == 1) {
                    x--;
                }
                i++;
            }
        }
        return length - i;
    }

    public static void main(String[] args) {
        Solution1004 solution = new Solution1004();
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
