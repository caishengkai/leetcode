package com.csk.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 用队列实现栈
 * @author: caishengkai
 * @time: 2022/3/19 15:49
 */
public class Solution225 {

    private Queue<Integer> queue1;

    private int top;
    public Solution225() {
        queue1 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue1.offer(x);
        top = x;
    }

    public int pop() {
        int size = queue1.size();
        while (size > 2) {
            queue1.offer(queue1.poll());
            size--;
        }
        top = queue1.peek();
        queue1.offer(queue1.poll());
        return queue1.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
