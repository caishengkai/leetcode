package com.csk.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * @author: caishengkai
 * @time: 2020/12/14 22:48
 */
public class Solution141_2 {

    public boolean hasCycle(ListNode141_2 head) {
        ListNode141_2 fast = head;
        ListNode141_2 slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

class ListNode141_2 {
    int val;
    ListNode141_2 next;
    ListNode141_2() {}
    ListNode141_2(int val) { this.val = val; }
    ListNode141_2(int val, ListNode141_2 next) { this.val = val; this.next = next; }
}