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
public class Solution876_2 {

    public ListNode876_2 middleNode(ListNode876_2 head) {
        ListNode876_2 fast = head;
        ListNode876_2 slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

class ListNode876_2 {
    int val;
    ListNode876_2 next;
    ListNode876_2(int val) { this.val = val; }
}
