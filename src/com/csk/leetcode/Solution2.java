package com.csk.leetcode;

/**
 * @description: 两数相加
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例 1：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author: caishengkai
 * @date: 2021-01-07 11:42
 */
public class Solution2 {

    /**
     * 两个链表向后遍历，两数相加，超10进位1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        boolean flag = false;
        ListNode2 result = new ListNode2(-1);
        ListNode2 temp = result;
        while (l1 != null || l2 != null) {
            int i = 0;
            int j = 0;
            int sum;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }

            sum = i + j;
            if (flag) {
                sum = sum + 1;
            }

            flag = sum / 10 > 0;

            int k = sum % 10;

            temp.next = new ListNode2(k);
            temp = temp.next;
        }

        if (flag) {
            temp.next = new ListNode2(1);
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode2 l1 = new ListNode2(2);
        l1.next = new ListNode2(4);
        l1.next.next = new ListNode2(3);
        ListNode2 l2 = new ListNode2(5);
        l2.next = new ListNode2(6);
        l2.next.next = new ListNode2(4);
        ListNode2 result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}


class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
