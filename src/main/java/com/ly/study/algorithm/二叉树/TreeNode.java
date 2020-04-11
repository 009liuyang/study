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

class test{

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
