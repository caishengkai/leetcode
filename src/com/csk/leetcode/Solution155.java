package com.csk.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author: caishengkai
 * @date: 2020-12-24 15:40
 */
public class Solution155 {

    /**
     * 额外维护一个辅助栈，根据栈先进后出的特点，每次插入当前值和栈顶值的较小者，出栈的时候一起弹出，保证每次在栈顶的都是栈里的最小值
     */
    Deque<Integer> stack;
    Deque<Integer> temp;

    /** initialize your data structure here. */
    public Solution155() {
        stack = new LinkedList<>();
        temp = new LinkedList<>();
        //辅助栈先插入一个最大值，防止为空的情况
        temp.push(Integer.MAX_VALUE);
    }

    /**
     * 辅助栈插入 当前值和栈顶值的较小者
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        //temp.push(Math.min(temp.peek(), x));
        if (x < temp.peek()) {
            temp.push(x);
        } else {
            temp.push(temp.peek());
        }
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return temp.peek();
    }

    public static void main(String[] args) {
        Solution155 solution = new Solution155();
        solution.push(2147483646);
        solution.push(2147483646);
        solution.push(2147483647);
        System.out.println(solution.top());
        solution.pop();
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.getMin());
        solution.pop();
        solution.push(2147483647);
        System.out.println(solution.top());
        System.out.println(solution.getMin());
        solution.push(-2147483648);
        System.out.println(solution.top());
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.getMin());
    }
}
