package com.csk.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 汇总区间
 *
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 *
 * 输入：nums = [0]
 * 输出：["0"]
 * 
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * @author: caishengkai
 * @date: 2021-01-10 09:27
 */
public class Solution228 {

    /**
     * 一次遍历，每次和前一个比较是否相差1
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        int prev = nums[0];
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev == 1) {
                prev = nums[i];
                flag = true;
            } else {
                if (flag) {
                    sb.append("->").append(prev);
                }
                result.add(sb.toString());
                flag = false;
                prev = nums[i];
                sb = new StringBuilder();
                sb.append(prev);
            }
        }
        if (flag) {
            sb.append("->").append(prev);
        }
        result.add(sb.toString());
        return result;
    }

    /**
     * 精简代码
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            StringBuilder sb = new StringBuilder();
            int j = i;
            while(j<nums.length-1 && nums[j+1]-nums[j] == 1){
                j++;
            }
            if(i != j){
                sb.append(nums[i]).append("->").append(nums[j]);
            }else{
                sb.append(nums[i]);
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution228 solution = new Solution228();
        System.out.println(solution.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

}
