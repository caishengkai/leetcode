package com.csk.leetcode;

/**
 * @description: 翻转二叉树
 * @author: caishengkai
 * @time: 2022/3/20 21:33
 */
public class Solution226 {

    public TreeNode226 invertTree(TreeNode226 root) {
        if (root == null) {
            return null;
        }
        TreeNode226 temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}

class TreeNode226 {
    int val;
    TreeNode226 left;
    TreeNode226 right;

    TreeNode226() {
    }

    TreeNode226(int val) {
        this.val = val;
    }

    TreeNode226(int val, TreeNode226 left, TreeNode226 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
