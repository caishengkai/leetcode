package com.csk.leetcode;

/**
 * @description: 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * @author: caishengkai
 * @date: 2021-01-29 11:14
 */
public class Solution647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int num = length;
        for (int i = 0; i <= length; i++) {
            for (int j = i+2; j <= length; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    num++;
                }
            }
        }
        return num;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }

    public static void main(String[] args) {
        Solution647 solution = new Solution647();
        System.out.println(solution.countSubstrings("abcaa"));
    }
}
