package com.csk.leetcode;

/**
 * @description: 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *
 * @author: caishengkai
 * @date: 2021-06-15 09:36
 */
public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr, 0, arr.length-1);
    }

    /**
     * 二分查找， 时间复杂度O(logn)
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private int binarySearch(int[] arr, int i, int j) {
        int middle = (i + j) / 2;
        if (middle == 0) {
            return 1;
        }
        if (arr[middle] > arr[middle-1] && arr[middle] > arr[middle+1]) {
            return middle;
        } else if (arr[middle] <= arr[middle-1]) {
            return binarySearch(arr, i, middle-1);
        } else {
            return binarySearch(arr, middle+1, j);
        }
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution852 solution = new Solution852();
        int[] arr = new int[]{3,4,5,1};
        System.out.println(solution.peakIndexInMountainArray(arr));
    }
}
