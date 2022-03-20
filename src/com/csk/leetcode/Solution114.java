package com.csk.leetcode;

/**
 * @description: 二叉树展开为链表
 * @author: caishengkai
 * @time: 2022/3/20 21:44
 */
public class Solution114 {

    /**
     *先用两个变量把原先的左右子树保存起来
     * 将左子树作为右子树(对照下图中第1个树变成第2个树，原来2的左子树3变成了2的右子树3)
     * 将原先的右子树接到当前右子树的末端（看下图第3棵树，5要接到4的下面）
     *
     * @param root
     */
    public void flatten(TreeNode114 root) {
        if (root == null) {
            return;
        }

        //递归到最底层
        flatten(root.left);
        flatten(root.right);
        //保持原先的左节点和又节点
        TreeNode114 left = root.left;
        TreeNode114 right = root.right;
        //把左节点作为又节点
        root.right = left;
        root.left = null;
        //再把之前的右节点接到现在的右节点末端
        while (root.right != null) {
            root = root.right;
        }

        root.right = right;
    }
}

class TreeNode114 {
    int val;
    TreeNode114 left;
    TreeNode114 right;

    TreeNode114() {
    }

    TreeNode114(int val) {
        this.val = val;
    }

    TreeNode114(int val, TreeNode114 left, TreeNode114 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}