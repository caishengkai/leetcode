package com.csk.leetcode;

/**
 * @description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author: caishengkai
 * @date: 2020-12-23 11:44
 */
public class Solution19 {

    /**
     * 二次遍历，第一次获取链表长度，计算出正序要删除的索引，第二次删除
     * @param head
     * @param n
     * @return
     */
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        int length = 0;
        ListNode19 temp = head;
        //链表长度
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n > length) {
            return head;
        }
        //获取要删除节点的正序索引
        int zn = length - n;
        if (zn == 0) {
            head = head.next;
        } else {
            temp = head;
            for (int i = 0; i < length; i++) {
                if (i + 1 == zn) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 一次遍历，快慢指针，快指针移动到n节点，然后快慢指针一起移动，直到快指针到达最后一个节点，这时慢指针next节点就是要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode19 removeNthFromEnd2(ListNode19 head, int n) {
        ListNode19 preHead = new ListNode19(-1, head);
        ListNode19 quick = preHead;
        ListNode19 slow = preHead;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        ListNode19 node = new ListNode19(1);
        node.next = new ListNode19(2);
        node.next.next = new ListNode19(3);
        node.next.next.next = new ListNode19(4);
        node.next.next.next.next = new ListNode19(5);
        node = solution.removeNthFromEnd2(node, 1);
        System.out.print(node.val + "->");
        System.out.print(node.next.val + "->");
        System.out.print(node.next.next.val + "->");
        System.out.print(node.next.next.next.val);
    }
}

class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19() {}
    ListNode19(int val) {
        this.val = val;
    }
    ListNode19(int val, ListNode19 next) {
        this.val = val; this.next = next;
    }
}