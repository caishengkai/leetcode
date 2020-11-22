package com.csk.leetcode;

/**
 * @description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 输入: [0,1,0,3,0,12,0,11]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author: caishengkai
 * @date: 2020-11-21 10:45
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    firstZero = j;
                    break;
                }
            }
            if (firstZero == -1) {
                return;
            }
            if (nums[i] != 0 && i > firstZero) {
                temp = nums[i];
                nums[i] = nums[firstZero];
                nums[firstZero] = temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        //两个指针i和j
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,4};
        Solution283 solution = new Solution283();
        solution.moveZeroes3(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
