package com.csk.leetcode;

/**
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母a-z。
 *
 * @author: caishengkai
 * @date: 2020-11-27 16:06
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }


    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
