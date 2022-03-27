package com.csk.leetcode;

/**
 * @description:
 * @author: caishengkai
 * @time: 2022/3/13 22:50
 */
public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getHours(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int getHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours = hours + pile / k;
            if (pile % k > 0) {
                hours++;
            }
        }
        return hours;
    }

    public int getMax(int [] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (max < piles[i]) {
                max = piles[i];
            }
        }
        return max;
    }
}
