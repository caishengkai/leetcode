package com.csk.leetcode;

/**
 * @description: 链表的中间结点
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 
 *
 * 提示：
 *
 * 给定链表的结点数介于1和100之间。
 *
 * @author: caishengkai
 * @date: 2020-12-24 10:19
 */
public class Solution876 {

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode876 middleNode(ListNode876 head) {
        ListNode876 quick = head;
        ListNode876 slow = head;

        while (quick != null) {
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution876 solution = new Solution876();
        ListNode876 node = new ListNode876(1);
        node.next = new ListNode876(2);
        node.next.next = new ListNode876(3);
        node.next.next.next = new ListNode876(4);
        node = solution.middleNode(node);
        System.out.print(node.val + "->");
        System.out.print(node.next.val + "->");
        System.out.print(node.next.next.val + "->");
        System.out.print(node.next.next.next.val);
    }
}

class ListNode876 {
    int val;
    ListNode876 next;
    ListNode876(int val) { this.val = val; }
}
