package com.csk.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 数组形式的整数加法
 *
 * 对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式A，返回整数X+K的数组形式。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * 
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果A.length > 1，那么A[0] != 0
 *
 * @author: caishengkai
 * @date: 2021-01-22 10:30
 */
public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int lenght = A.length;
        int sum;
        for (int i = lenght-1; i >= 0; i--) {
            sum = A[i] + K % 10;
            K = K / 10;
            if (sum >= 10) {
                K++;
                sum = sum - 10;
            }
            result.add(sum);
        }
        while (K > 0) {
            result.add(K % 10);
            K = K / 10;
        }
        Collections.reverse(result);
        return  result;
    }

    public static void main(String[] args) {
        Solution989 solution = new Solution989();
        System.out.println(solution.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }
}
