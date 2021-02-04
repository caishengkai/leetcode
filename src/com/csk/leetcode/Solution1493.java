package com.csk.leetcode;

/**
 * @description: 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组nums，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 *
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 *
 * 输入：nums = [0,0,0]
 * 输出：0
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * nums[i]要么是0要么是1 。
 *
 * @author: caishengkai
 * @date: 2021-02-04 17:45
 */
public class Solution1493 {

    /**
     * 滑动窗口 等同于 替换k=1个数
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int x = 0;
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] == 1) {
                x++;
            }
            if (j - i + 1 > x + 1) {
                if (nums[i] == 1) {
                    x--;
                }
                i++;
            }
        }
        return length - i - 1;
    }

    public static void main(String[] args) {
        Solution1493 solution = new Solution1493();
        System.out.println(solution.longestSubarray(new int[]{0,0,0}));
    }
}
