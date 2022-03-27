package com.csk.leetcode;

/**
 * @description:
 * @author: caishengkai
 * @time: 2022/3/13 22:24
 */
public class Solution704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] <target) {
                left = mid + 1;
            }
        }

        return -1;
    }

}
