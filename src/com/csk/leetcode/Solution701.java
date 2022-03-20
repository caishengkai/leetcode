package com.csk.leetcode;

/**
 * @description: 二叉搜索树中的插入操作
 * @author: caishengkai
 * @time: 2022/3/20 23:01
 */
public class Solution701 {

    public TreeNode701 insertIntoBST(TreeNode701 root, int val) {

        if (root == null) {
            return new TreeNode701(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

class TreeNode701 {
    int val;
    TreeNode701 left;
    TreeNode701 right;

    TreeNode701() {
    }

    TreeNode701(int val) {
        this.val = val;
    }

    TreeNode701(int val, TreeNode701 left, TreeNode701 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}