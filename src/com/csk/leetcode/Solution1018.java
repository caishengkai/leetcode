package com.csk.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 可被 5 整除的二进制前缀
 *
 * 给定由若干0和1组成的数组 A。我们定义N_i：从A[0] 到A[i]的第 i个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表answer，只有当N_i可以被 5整除时，答案answer[i] 为true，否则为 false。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *
[1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1]
输出：
[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,true,false,false,false,false]
预期结果：
[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false]
 *
 * @author: caishengkai
 * @date: 2021-01-14 09:37
 */
public class Solution1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> result = new ArrayList<>(A.length);
        int num = 0;
        for (int j : A) {
            num <<= 1;
            num += j;
            num %= 5;
            System.out.print(num + " ");
            result.add(num == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1018 solution = new Solution1018();
        System.out.println(solution.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
    }

}
