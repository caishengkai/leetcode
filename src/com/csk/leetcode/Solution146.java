package com.csk.leetcode;

import java.util.LinkedHashMap;

/**
 * @description: LRU缓存
 * @author: caishengkai
 * @date: 2022-03-23 10:40
 */
public class Solution146 {

    private LinkedHashMap<Integer, Integer> lru;
    private int size;
    public Solution146(int capacity) {
        lru = new LinkedHashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (!lru.containsKey(key)) {
            return -1;
        }
        markTop(key);
        return lru.get(key);
    }

    public void put(int key, int value) {
        if (lru.containsKey(key)) {
            lru.put(key, value);
            markTop(key);
        } else {
            if (lru.size() >= size) {
                int firstKey = lru.keySet().iterator().next();
                lru.remove(firstKey);
            }
            lru.put(key, value);
        }
    }

    private void markTop(int key) {
        int value = lru.get(key);
        lru.remove(key);
        lru.put(key, value);
    }

    public static void main(String[] args) {
        Solution146 cache = new Solution146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
