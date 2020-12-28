package com.csk.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * 
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * @author: caishengkai
 * @date: 2020-12-28 14:05
 */
public class Solution844 {
    /**
     * 栈，遇到#弹出
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(T.charAt(i));
            }
        }

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 重新构造字符串
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution844 solution = new Solution844();
        System.out.println(solution.backspaceCompare2("abcd", "bbcd"));
    }
}
