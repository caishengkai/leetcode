package com.csk.leetcode;

/**
 * @description: 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author: caishengkai
 * @date: 2021-01-07 14:39
 */
public class Solution24 {

    /**
     * 循环 交换
     * @param head
     * @return
     */
    public ListNode24 swapPairs(ListNode24 head) {
        ListNode24 perv = new ListNode24(-1);
        perv.next = head;
        ListNode24 temp = perv;
        ListNode24 start;
        ListNode24 end;
        while (temp.next != null && temp.next.next != null) {
            start = temp.next;
            end = temp.next.next;
            start.next = end.next;
            temp.next = end;
            end.next = start;
            temp = start;
        }
        return perv.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode24 swapPairs2(ListNode24 head) {
        if (head == null || head.next == null) {
            return head;
        }
        //第二个节点
        ListNode24 next = head.next;
        //头节点的后继等于交换完的链表
        head.next = swapPairs2(next.next);
        //第二个节点变为头节点
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        ListNode24 node = new ListNode24(1);
        node.next = new ListNode24(2);
        node.next.next = new ListNode24(3);
        node.next.next.next = new ListNode24(4);
        ListNode24 result = solution.swapPairs2(node);
        System.out.println(result);
    }
}

class ListNode24 {
    int val;
    ListNode24 next;
    ListNode24() {}
    ListNode24(int val) {
        this.val = val;
    }
    ListNode24(int val, ListNode24 next) {
        this.val = val; this.next = next;
    }
}
