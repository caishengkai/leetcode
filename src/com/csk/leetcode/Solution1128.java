package com.csk.leetcode;

/**
 * @description: 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b]和dominoes[j] = [c, d]等价的前提是a==c且b==d，或是a==d 且b==c。
 *
 * 在0 <= i < j < dominoes.length的前提下，找出满足dominoes[i] 和dominoes[j]等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * 5 --- 4 3 2 1     10 5-1 * 5 / 2
 * 6 --- 5 4 3 2 1   15 6-1 * 6 / 2
 * 7 --- 6 5 4 3 2 1 21 7-1 * 7 / 2
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * 
 * @author: caishengkai
 * @date: 2021-01-26 09:26
 */
public class Solution1128 {
    /**
     *  1 2 -- 1*10+2   2 1 -- 1*10+2
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[99];
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] >= dominoes[i][1]) {
                num[dominoes[i][0]*10+dominoes[i][1]]++;
            } else {
                num[dominoes[i][1]*10+dominoes[i][0]]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 1) {
                sum+= (num[i]-1) * num[i] / 2;
            }
        }
        return sum;
    }

    /**
     * 官方解答
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs2(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1128 solution = new Solution1128();
        int[][] dominoes = {{1,2}, {2,1}, {3,4}, {5,6}, {4,3}, {5,6}};
        int[][] arr = {{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}};
        System.out.println(solution.numEquivDominoPairs(arr));
    }
}