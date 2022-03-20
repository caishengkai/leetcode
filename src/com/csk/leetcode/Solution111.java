package com.csk.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的最小深度
 * @author: caishengkai
 * @time: 2022/3/20 23:28
 */
public class Solution111 {
    public int minDepth(TreeNode111 root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode111> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode111 node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

class TreeNode111 {
    int val;
    TreeNode111 left;
    TreeNode111 right;

    TreeNode111() {
    }

    TreeNode111(int val) {
        this.val = val;
    }

    TreeNode111(int val, TreeNode111 left, TreeNode111 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
