package com.csk.leetcode;

import java.util.Arrays;

/**
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * @author: caishengkai
 * @time: 2020/11/22 20:45
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        //按字符从小到大排序
        Arrays.sort(cs);
        Arrays.sort(ct);
        //字符数组转换成字符串比较
        return String.valueOf(cs).equals(String.valueOf(ct));
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] temp = new int[26];
        //哈希数组，同一个字符 出现在cs就加一，出现在ct就减一
        for (int i = 0; i < cs.length; i++) {
            temp[cs[i] - 'a']++;
            temp[ct[i] - 'a']--;
        }
        //判断字符是否都为0，为0表示2个数组里出现的字符相同且相同的字符数量也相同
        for (int i = 0; i < 26; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        System.out.println(solution.isAnagram1("abcvvcvv", "vvbadvcv"));
    }
}
