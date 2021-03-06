package com.csk.leetcode;

/**
 * @description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author: caishengkai
 * @date: 2020-11-24 09:40
 */
public class Solution21 {

    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode21 newHead = new ListNode21(0);
        newHead.next = l1;
        while (l1.next != null) {
            l1 = l1.next;
        }
        ListNode21 lastSorted = l1;
        while (l2 != null) {
            ListNode21 currL2 = l2;
            if (lastSorted.val <= currL2.val) {
                lastSorted.next = currL2;
                return newHead.next;
            } else {
                ListNode21 prev = newHead;
                while (prev.next.val <= currL2.val) {
                    prev = prev.next;
                }
                ListNode21 insertNode = new ListNode21(currL2.val);
                insertNode.next = prev.next;
                prev.next = insertNode;
            }
            l2 = l2.next;
        }
        return newHead.next;
    }

    public ListNode21 mergeTwoLists2(ListNode21 l1, ListNode21 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode21 mergeTwoLists3(ListNode21 l1, ListNode21 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode21 virtualHead = new ListNode21(-1, null);
        ListNode21 prev = virtualHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return virtualHead.next;
    }

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        ListNode21 node = new ListNode21(2);
        node.next = new ListNode21(4);
        node.next.next = new ListNode21(6);
        node.next.next.next = new ListNode21(8);
        ListNode21 node2 = new ListNode21(1);
        node2.next = new ListNode21(3);
        node2.next.next = new ListNode21(5);
        node2.next.next.next = new ListNode21(7);
        node = solution.mergeTwoLists3(node, node2);
        System.out.print(node.val + "->");
        System.out.print(node.next.val + "->");
        System.out.print(node.next.next.val + "->");
        System.out.print(node.next.next.next.val);
    }

}

class ListNode21 {
    int val;
    ListNode21 next;
    ListNode21() {}
    ListNode21(int val) {
        this.val = val;
    }
    ListNode21(int val, ListNode21 next) {
        this.val = val; this.next = next;
    }
}
 