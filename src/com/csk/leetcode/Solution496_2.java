package com.csk.leetcode;

import java.util.*;

/**
 * @description: 下一个更大元素 I
 * 给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 *
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2的数组大小都不超过1000。
 *
 * @author: caishengkai
 * @date: 2022-03-20 14:50
 */
public class Solution496_2 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = this.nextGreaterMap(nums2);
        int[] result = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public Map<Integer, Integer> nextGreaterMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > nums[i]) {
                    map.put(nums[i], stack.peek());
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                map.put(nums[i], -1);
            }
            stack.push(nums[i]);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution496_2 solution = new Solution496_2();
        int[] result = solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
