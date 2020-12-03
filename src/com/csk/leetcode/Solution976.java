package com.csk.leetcode;

import java.util.Arrays;

/**
 * @description: 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回0。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 * 
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *
 * @author: caishengkai
 * @date: 2020-11-30 09:13
 */
public class Solution976 {

    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        //升序排序
        Arrays.sort(A);

        //只要最大的数小于第二大和第三大之和，那么这3个数相加周长最大
        for (int i = A.length-1; i >= 2 ; i--) {
            if (A[i] < (A[i-1] + A[i-2])) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution976 solution = new Solution976();
        System.out.println(solution.largestPerimeter(new int[]{3,6,2,3}));
    }

}
