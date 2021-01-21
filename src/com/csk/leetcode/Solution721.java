package com.csk.leetcode;

import java.util.*;

/**
 * @description: 账号合并
 *
 * 给定一个列表 accounts，每个元素 accounts[i]是一个字符串列表，其中第一个元素 accounts[i][0]是名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * 
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 * 两个账户需要合并，当且仅当两个账户至少有一个共同的邮箱地址，因此这道题的实质是判断所有的邮箱地址中有哪些邮箱地址必定属于同一人，可以使用并查集实现。
 *
 * 为了使用并查集实现账户合并，需要知道一共有多少个不同的邮箱地址，以及每个邮箱对应的名称，因此需要使用两个哈希表分别记录每个邮箱对应的编号和每个邮箱对应的名称，遍历所有的账户并在两个哈希表中记录相应的信息。虽然同一个邮箱地址可能在多个账户中出现，但是同一个邮箱地址在两个哈希表中都只能存储一次。
 *
 * 然后使用并查集进行合并操作。由于同一个账户中的邮箱地址一定属于同一个人，因此遍历每个账户，对账户中的邮箱地址进行合并操作。并查集存储的是每个邮箱地址对应的编号，合并操作也是针对编号进行合并。
 *
 * 完成并查集的合并操作之后，即可知道合并后有多少个不同的账户。遍历所有的邮箱地址，对于每个邮箱地址，通过并查集得到该邮箱地址属于哪个合并后的账户，即可整理出每个合并后的账户包含哪些邮箱地址。
 *
 * 对于每个合并后的账户，需要整理出题目要求的返回账户的格式，具体做法是：将邮箱地址排序，账户的名称可以通过在哈希表中查找任意一个邮箱对应的名称得到，将名称和排序后的邮箱地址整理成一个账户列表。对所有合并后的账户整理出账户列表，即可得到最终答案。
 *
 * @author: caishengkai
 * @date: 2021-01-18 09:18
 */
public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //邮箱对应编号Map
        Map<String, Integer> emailIndexMap = new HashMap<>();
        //邮箱对象账户Map
        Map<String, String> emailNameMap = new HashMap<>();

        int emailCount = 0;
        for (List<String> list : accounts) {
            //邮箱账户名
            String emailName = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (!emailIndexMap.containsKey(list.get(i))) {
                    emailIndexMap.put(list.get(i), emailCount++);
                    emailNameMap.put(list.get(i), emailName);
                }
            }
        }

        UnionFind unionFind = new UnionFind(emailCount);
        for (List<String> list : accounts) {
            //索引2，第一个邮箱，作为根节点
            //第一个邮箱对应的编号
            int firstEmailIndex = emailIndexMap.get(list.get(1));
            int size = list.size();
            for (int i = 2; i < size; i++) {
                //后面的邮箱作为子节点
                //后面邮箱对应的编号
                int nextEmailIndex = emailIndexMap.get(list.get(i));
                //因为邮箱都属于同一个账号，所以直接合并
                unionFind.union(firstEmailIndex, nextEmailIndex);
            }
        }

        //根据根节点分组，每个根节点对应一个账号
        Map<Integer, LinkedList<String>> indexEmailMap = new HashMap<>();
        for (String email : emailIndexMap.keySet()) {
            int index = unionFind.find(emailIndexMap.get(email));
            LinkedList<String> emailList = indexEmailMap.getOrDefault(index, new LinkedList<>());
            emailList.add(email);
            indexEmailMap.put(index, emailList);
        }

        //给分组后的map添加账号
        List<List<String>> result = new ArrayList<>();
        for (Integer index : indexEmailMap.keySet()) {
            LinkedList<String> emailList = indexEmailMap.get(index);
            Collections.sort(emailList);
            emailList.addFirst(emailNameMap.get(emailList.get(0)));
            result.add(emailList);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution721 solution = new Solution721();
        List<List<String>> param = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");
        param.add(list1);
        list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnnybravo@mail.com");
        param.add(list1);
        list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john_newyork@mail.com");
        param.add(list1);
        list1 = new ArrayList<>();
        list1.add("Mary");
        list1.add("mary@mail.com");
        param.add(list1);
        System.out.println(solution.accountsMerge(param));
    }
}

/**
 * 并查集工具类
 */
class UnionFind {
    int[] parent;

    /**
     * 初始化每个元素的父节点是它自己
     * @param n 元素个数
     */
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 递归查询元素的最终父节点
     * @param x 元素索引
     * @return
     */
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    /**
     * 合并，将i的父节点设置为j的父节点
     * @param i 元素i
     * @param j 元素j
     */
    public void union(int i, int j) {
        parent[find(i)] = find(j);
    }
}
