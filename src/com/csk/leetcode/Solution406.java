package com.csk.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 按 k从大到小，h从小到大
 * [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author: caishengkai
 * @date: 2020-11-16 14:30
 */
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {
        //冒泡排序按 k从大到小，h从小到大
        for (int i = 0; i < people.length; i++) {
            for (int j = 1; j < people.length - i; j++) {
                if (people[j-1][0] < people[j][0] || (people[j-1][0] == people[j][0] && people[j-1][1] > people[j][1])) {
                    int x = people[j-1][0];
                    int y = people[j-1][1];
                    people[j-1][0] = people[j][0];
                    people[j-1][1] = people[j][1];
                    people[j][0] = x;
                    people[j][1] = y;
                }
            }
        }

        int[][] temp = new int[people.length][2];

        //k从大到小，后面的都比前面的矮，又因为h是比自己高的个数，所以h就是所在的位置，从头开始遍历，把每项插入到h位置即可
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], i);
        }

        for (int i = 0; i < people.length; i++) {
            temp[i][0] = people[list.get(i)][0];
            temp[i][1] = people[list.get(i)][1];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution406 solution = new Solution406();
        people = solution.reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            if (i == people.length-1) {
                System.out.print("[" + people[i][0] + "," + people[i][1] + "]");
            } else {
                System.out.print("[" + people[i][0] + "," + people[i][1] + "], ");
            }
        }
    }
}
