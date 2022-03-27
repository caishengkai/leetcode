package com.csk.leetcode;

/**
 * @description:
 * @author: caishengkai
 * @time: 2022/3/10 23:01
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String a = palindrome(s, i, i);
            String b = palindrome(s, i, i+1);
            result = result.length() > a.length() ? result : a;
            result = result.length() > b.length() ? result :b;
        }
        return result;
    }

    public String palindrome(String s, int i, int j) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }
}
