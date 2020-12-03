package com.csk.leetcode;

/**
 * @description: 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * @author: caishengkai
 * @date: 2020-12-03 09:46
 */
public class Solution767 {
    public String reorganizeString(String S) {
        int total = S.length();
        //重复字符超过总数一半，则不存在两相邻的字符不同
        int temp = total % 2 == 0 ? total / 2 : total / 2 + 1;
        int[] nums = new int[26];
        //放入桶
        for (int i = 0; i < total; i++) {
            nums[S.charAt(i) - 'a']++;
        }
        //找出重复最多的那个字符
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        //判断阈值
        if (nums[max] > temp) {
            return "";
        }
        char[] cs = new char[total];
        int j=0;
        //先把重复最多的那个字符插入偶数位
        for (int i = 0; i < nums[max]; i++) {
            cs[j] = (char) (max + 'a');
            j = j + 2;
        }

        //剩下的先把偶数位插满，再插奇数位
        for (int i = 0; i < 26; i++) {
            if (i == max || nums[i] == 0) {
                continue;
            }
            for (int k = 0; k < nums[i]; k++) {
                if (j > total - 1) {
                    j = 1;
                }
                cs[j] = (char) (i + 'a');
                j = j + 2;
            }
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        Solution767 solution = new Solution767();
        System.out.println(solution.reorganizeString("abbabbaaab"));
    }
}
