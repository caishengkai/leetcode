package com.csk.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @description: LFU
 * @author: caishengkai
 * @date: 2022-03-23 14:30
 */
public class Solution460 {

    Map<Integer, Integer> keyValueMap;
    Map<Integer, Integer> keyFreqMap;
    Map<Integer, LinkedHashSet<Integer>> freqKeyLisyMap;
    int minFreq;
    int size;

    public Solution460(int capacity) {
        keyValueMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        freqKeyLisyMap = new HashMap<>();
        size = capacity;
        minFreq = 1;
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }
        this.temp(key);
        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        //如果key存在，就更新value和freq
        if (keyValueMap.containsKey(key)) {
            this.temp(key);
            keyValueMap.put(key, value);
            return;
        }
        LinkedHashSet<Integer> minKeyList = freqKeyLisyMap.get(minFreq);
        //数量超了，移除之前的频率最低，且最早的
        if (keyValueMap.size() >= size) {
            int firstKey = minKeyList.iterator().next();
            minKeyList.remove(firstKey);
            keyValueMap.remove(firstKey);
            keyFreqMap.remove(firstKey);
        }
        //之前的最小频率大于1，往freqKeyLisyMap里插入当前key，并将最小频率改为1
        if (minFreq > 1) {
            LinkedHashSet<Integer> oneFreqkeyList = new LinkedHashSet<>();
            oneFreqkeyList.add(key);
            freqKeyLisyMap.put(1, oneFreqkeyList);
            minFreq = 1;
        } else {
            if (minKeyList == null) {
                minKeyList = new LinkedHashSet<>();
            }
            minKeyList.add(key);
            freqKeyLisyMap.put(minFreq, minKeyList);
        }
        keyValueMap.put(key, value);
        keyFreqMap.put(key, minFreq);
    }

    private void temp(int key) {
        //找到原先的访问频率
        int freq = keyFreqMap.get(key);
        //更新频率+1
        keyFreqMap.put(key, freq+1);
        //更新freq->keylist
        LinkedHashSet<Integer> old = freqKeyLisyMap.get(freq);
        LinkedHashSet<Integer> news = freqKeyLisyMap.get(freq+1);
        //老的list里移除
        old.remove(key);
        //如果最小频率对应的keylist为空，则最小频率加一
        if (minFreq == freq && old.size() == 0) {
            minFreq++;
        }
        //新的list里添加
        if (news == null) {
            news = new LinkedHashSet<>();
        }
        news.add(key);
        //塞回到map
        freqKeyLisyMap.put(freq, old);
        freqKeyLisyMap.put(freq+1, news);
    }

    public static void main(String[] args) {
        /*Solution460 cache = new Solution460(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));*/
        Solution460 cache = new Solution460(10);
        //cache.put(0, 0);
        //System.out.println(cache.get(0));

        int[][] param = new int[][]{{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
        for (int i = 0; i < param.length; i++) {
            if (param[i].length == 1) {
                System.out.println("param[i][0]=" + param[i][0] + ":" + cache.get(param[i][0]));
            } else {
                cache.put(param[i][0], param[i][1]);
            }
        }
    }
}
