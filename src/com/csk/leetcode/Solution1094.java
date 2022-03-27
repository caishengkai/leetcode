package com.csk.leetcode;

/**
 * @description:
 * @author: caishengkai
 * @time: 2022/3/9 21:42
 */
public class Solution1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] temp = new int[1000];
        for (int[] trip : trips) {
            for (int j = trip[1]; j < trip[2]; j++) {
                temp[j] = temp[j] + trip[0];
            }
        }
        for (int i : temp) {
            if (i > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] = diff[trip[1]] + trip[0];
            diff[trip[2]] = diff[trip[2]] - trip[0];
        }

        int[] res = new int[1001];
        res[0] = diff[0];
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i-1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
