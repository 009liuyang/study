package com.ly.study.algorithm.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe 二叉树前中后序遍历
 * @author yang.liu
 * @date 2020-04-08
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

class print{

    static List<Integer> list = new ArrayList<>();

    /**
     * 前序遍历 : 根 -> 左 -> 右
     */
    public static void qianxu(TreeNode node){
        list.add(node.val);

        if(node.left != null){
            qianxu(node.left);
        }

        if(node.right != null){
            qianxu(node.right);
        }
    }

    /**
     * 中序遍历 : 左 -> 根 -> 右
     */
    public static void zhongxu(TreeNode node){
        if(node.left != null){
            zhongxu(node.left);
        }

        list.add(node.val);

        if(node.right != null){
            zhongxu(node.right);
        }
    }

    /**
     * 后序遍历 : 左 -> 右 -> 跟
     */
    public static void houxu(TreeNode node){
        if(node.left != null){
            houxu(node.left);
        }

        if(node.right != null){
            houxu(node.right);
        }

        list.add(node.val);
    }
}

class depth{

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode7;
        treeNode2.left = treeNode3;

        treeNode.right = treeNode4;
        treeNode4.right= treeNode5;
        treeNode4.left = treeNode8;

        System.out.println(maxDepth(treeNode));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            System.out.println("before"+root.val);
            int left_height = maxDepth(root.left);
            System.out.println("after"+root.val);
            int right_height = maxDepth(root.right);
            int x = java.lang.Math.max(left_height, right_height) + 1;
            System.out.println(x);
            return x;
        }
    }


    public int qianxu1(TreeNode tree){
        if(tree == null) return 0;
        int countLeft = qianxu1(tree.left);
        int countRight = qianxu1(tree.right);
        return Math.max(countLeft,countRight);
    }

    public static void main(String[] args) {
        new qianxu1(tree);
    }
}
