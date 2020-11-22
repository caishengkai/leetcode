package com.csk.leetcode;

/**
 * @description: 对链表进行插入排序
 * @author: caishengkai
 * @time: 2020/11/22 21:22
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义已排序链表的最后一个节点（也就是最大节点），初始为第一个节点
        ListNode lastSorted = head;
        //定义当前要插入的节点，初始为第二个节点
        ListNode curr = head.next;
        while (curr != null) {
            //如果要插入的节点比已排序的最大节点还要大，将lastSorted移到curr位置
            if (lastSorted.val <= curr.val) {
                lastSorted = curr;
            } else { //从头开始遍历，找到第一个比curr大的，插入到它前面
                ListNode prev = head;
                //如果curr比头节点还要小，就插入到头节点
                if (curr.val <= prev.val) {
                    lastSorted.next = curr.next;
                    curr.next = prev;
                    head = curr;
                } else {
                    //循环遍历，找比curr大的
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    //插入到prev前面
                    lastSorted.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                }
            }
            //curr移到后面一个
            curr = lastSorted.next;
        }
        return head;
    }

    /**
     * 参考题解，定义一个虚的头节点，这样不用特殊处理 curr比头节点还要小 的情况
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = curr;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution147 solution = new Solution147();
        ListNode node = new ListNode(4);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node = solution.insertionSortList1(node);
        System.out.print(node.val + "->");
        System.out.print(node.next.val + "->");
        System.out.print(node.next.next.val + "->");
        System.out.print(node.next.next.next.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
