package com.csk.leetcode;

import java.util.Arrays;

/**
 * @description: 旋转数组
 * 
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为O(1) 的原地算法。
 * 
 * @author: caishengkai
 * @date: 2021-01-08 09:20
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length-1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = last;
        }
    }

    /**
     * 该方法基于如下的事实：当我们将数组的元素向右移动 kk 次后，尾部 k\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k\bmod nkmodn 个位置。
     *
     * 该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int temp = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, temp-1);
        reverse(nums, temp, nums.length-1);
    }

    /**
     * 反转数组
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution189 solution = new Solution189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        solution.rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
