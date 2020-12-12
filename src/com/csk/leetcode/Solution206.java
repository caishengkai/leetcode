package com.csk.leetcode;

/**
 * @description: 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author: caishengkai
 * @time: 2020/12/12 22:42
 */
public class Solution206 {

    public ListNode206 reverseList(ListNode206 head) {
        if (head == null || head.next == null) {
            return head;
        }

        //定义虚拟头节点
        ListNode206 first = new ListNode206(0, head);
        //当前需要移动的节点，初始是第二个节点
        ListNode206 temp = head.next;
        while (head.next != null) {
            //将temp节点断开
            head.next = temp.next;
            //temp节点移动到头结点
            temp.next = first.next;
            //连接虚拟节点
            first.next = temp;
            //重置temp节点为当前需要移动的节点
            temp = head.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode206 node = new ListNode206(1, new ListNode206(2, new ListNode206(3, new ListNode206(4, null))));
        Solution206 solution = new Solution206();
        node = solution.reverseList(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}

class ListNode206 {
    int val;
    ListNode206 next;
    ListNode206() {}
    ListNode206(int val) { this.val = val; }
    ListNode206(int val, ListNode206 next) { this.val = val; this.next = next; }
}
