package com.csk.leetcode;

/**
 * @description: 替换后的最长重复字符
 * 你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过104。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 题解：
 * 上图的求解过程展示中，窗口从左至右不断扩张/滑动，当窗口触达字符串末尾字符时，运算结束，窗口的宽度为最终结果。初始窗口的宽度为 1，
 * 我们不断的通过向当前窗口覆盖的子串后面追加一个字符看是否能满足我们的要求，如果满足窗口扩张，如果不满足，窗口向右滑动。
 *
 * 当 K>0 时，子串的条件变成了允许我们变换子串中的 K 个字符使其变成一个连续子串
 *
 * 那么这个题的关键点就是我们如何判断一个字符串改变 K 个字符，能够变成一个连续串
 *
 * 如果当前字符串中的出现次数最多的字母个数 +K 大于串长度，那么这个串就是满足条件的
 *
 * 我们维护一个数组 int[26] 来存储当前窗口中各个字母的出现次数，leftleft 表示窗口的左边界，rightright 表示窗口右边界
 *
 * 窗口扩张：leftleft 不变，right++right++
 * 窗口滑动：left++left++，right++right++
 * historyCharMaxhistoryCharMax 保存滑动窗口内相同字母出现次数的 历史 最大值，
 * 通过判断窗口宽度 (right - left + 1)(right−left+1) 是否大于 historyCharMax + KhistoryCharMax+K 来决定窗口是否做滑动，否则窗口就扩张。
 *
 * @author: caishengkai
 * @date: 2021-02-02 09:31
 */
public class Solution424 {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        if (k >= length || length < 2) {
            return length;
        }
        int left = 0;
        int right = 0;
        int[] chars = new int[26];
        //历史相同字符最大出现次数
        int historyCharMax = 0;
        while (right < length) {
            int index = s.charAt(right) - 'A';
            //每次右边扩张，把当前的字符出现次数加1
            chars[index]++;
            //重新赋予最大值
            historyCharMax = Math.max(historyCharMax, chars[index]);
            //比较当前窗口是否大于 最大出现次数+k
            if (right - left + 1 >  historyCharMax + k) {
                //先减，再移动
                chars[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right-left;
    }

    public static void main(String[] args) {
        Solution424 solution = new Solution424();
        System.out.println(solution.characterReplacement("ABAA", 0));
    }
}
