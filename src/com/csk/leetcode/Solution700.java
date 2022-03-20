package com.csk.leetcode;

/**
 * @description: 二叉搜索树中的搜索
 * @author: caishengkai
 * @time: 2022/3/20 22:11
 */
public class Solution700 {

    public TreeNode700 searchBST(TreeNode700 root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

}

class TreeNode700 {
    int val;
    TreeNode700 left;
    TreeNode700 right;

    TreeNode700() {
    }

    TreeNode700(int val) {
        this.val = val;
    }

    TreeNode700(int val, TreeNode700 left, TreeNode700 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}