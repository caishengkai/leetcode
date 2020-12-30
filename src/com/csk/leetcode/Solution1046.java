package com.csk.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * 
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * @author: caishengkai
 * @date: 2020-12-30 09:18
 */
public class Solution1046 {

    /**
     * 转成list，先排序，再比较
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        List<Integer> list = new LinkedList<>();
        for (int stone : stones) {
            list.add(stone);
        }

        Collections.sort(list);

        while (list.size() > 1) {
            int size = list.size();
            int i = list.get(list.size() - 1);
            int j = list.get(list.size() - 2);
            int k = Math.abs(i - j);
            list.remove(size - 1);
            list.remove(size - 2);
            if (k != 0) {
                list.add(k);
            }
            Collections.sort(list);
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        return 0;
    }

    /**
     * 数组直接排序，比较
     * @param stones
     * @return
     */
    public int lastStoneWeight1(int[] stones) {

        int size = stones.length;
        while (size > 1) {
            Arrays.sort(stones);
            int k = stones[size-1] - stones[size-2];
            if (k > 0) {
                size = size - 1;
                stones[size - 1] = k;
            } else {
                size = size - 2;
            }
        }

        if (size == 1) {
            return stones[size - 1];
        }

        return 0;

    }

    public static void main(String[] args) {
        Solution1046 solution = new Solution1046();
        System.out.println(solution.lastStoneWeight1(new int[]{2,7,4,1,8,1}));
    }
}
