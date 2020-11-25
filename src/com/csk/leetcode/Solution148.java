package com.csk.leetcode;

/**
 * @description: 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 方法一：自顶向下归并排序
 * 对链表自顶向下归并排序的过程如下。
 *
 * 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
 *
 * 对两个子链表分别排序。
 *
 * 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
 *
 * 上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 1，即当链表为空或者链表只包含 1 个节点时，不需要对链表进行拆分和排序。
 *
 * @author: caishengkai
 * @date: 2020-11-23 09:17
 */
public class Solution148 {
    public ListNode148 sortList(ListNode148 head) {
        if (head == null || head.next == null) {
            return head;
        }

        //快慢指针找到中间点
        ListNode148 h1 = head.next;
        ListNode148 h2 = head;
        while (h1 != null && h1.next != null) {
            h1 = h1.next.next;
            h2 = h2.next;
        }

        //把链表从中间点断开
        ListNode148 tmp = h2.next;
        h2.next = null;

        ListNode148 left = sortList(head);
        ListNode148 right = sortList(tmp);

        return mergeTwoLists(left, right);
    }

    private ListNode148 mergeTwoLists(ListNode148 l1, ListNode148 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution148 solution = new Solution148();
        ListNode148 node = new ListNode148(2);
        node.next = new ListNode148(4);
        node.next.next = new ListNode148(6);
        node.next.next.next = new ListNode148(8);
        solution.sortList(node);
        System.out.print(node.val + "->");
        System.out.print(node.next.val + "->");
        System.out.print(node.next.next.val + "->");
        System.out.print(node.next.next.next.val);
    }
}

class ListNode148 {
    int val;
    ListNode148 next;
    ListNode148() {}
    ListNode148(int val) { this.val = val; }
    ListNode148(int val, ListNode148 next) { this.val = val; this.next = next; }
}