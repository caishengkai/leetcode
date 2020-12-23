package com.csk.leetcode;

/**
 * @description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * @author: caishengkai
 * @date: 2020-12-23 10:15
 */
public class Solution387 {

    public int firstUniqChar(String s) {

        if (s == null || "".equals(s)) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        int[] nums = new int[26];
        //第一次遍历记录每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        //第二次遍历查看第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution387 solution = new Solution387();
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}
