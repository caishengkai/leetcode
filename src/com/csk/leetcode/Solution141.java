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
public class Solution141 {

    /**
     * 哈希表记录法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode141 head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode141> set = new HashSet<>();
        while (head != null && set.add(head)) {
            head = head.next;
        }
        if (head == null) {
            return false;
        }
        return true;
    }


    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode141 head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode141 fast = head.next;
        ListNode141 slow = head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }

        return false;
    }
}

class ListNode141 {
    int val;
    ListNode141 next;
    ListNode141() {}
    ListNode141(int val) { this.val = val; }
    ListNode141(int val, ListNode141 next) { this.val = val; this.next = next; }
}