package com.csk.leetcode;

import java.util.*;

/**
 * @description: 二叉树的层序遍历
 * @author: caishengkai
 * @time: 2022/3/20 23:44
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode102 root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //根节点
        result.add(Collections.singletonList(root.val));

        Queue<TreeNode102> queue = new LinkedList<>();
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode102 node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}

class TreeNode102 {
    int val;
    TreeNode102 left;
    TreeNode102 right;

    TreeNode102() {
    }

    TreeNode102(int val) {
        this.val = val;
    }

    TreeNode102(int val, TreeNode102 left, TreeNode102 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
