package com.leetcode.dynamicProgramming.test95;

import java.util.ArrayList;
import java.util.List;

/* 95 不同的二叉搜索树*/
public class MySolution {

    public static void main(String[] args) {

    }
     public List<TreeNode> generateTrees(int n) {
         if (n == 0) return null;
         return generateRoot(1, n);
     }
     /* 1.应当遍历1~n之间的结点，让他们都可以做根节点
      * 2.以根节点将整个序列分为两部分(1, i-1)和(i+1, n)
      * 3.分别对左右两部分序列再进行递归
      * 4.直到这个区间不可再分
      * */
    public List<TreeNode> generateRoot(int start, int end) {
        List<TreeNode> resTrees = new ArrayList<>();
        if (start > end) return resTrees;
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTrees = generateRoot(start, i - 1);
            List<TreeNode> rightTrees = generateRoot(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = left;
                    curRoot.right = right;
                    resTrees.add(curRoot);
                }
            }
        }
        return resTrees;
    }
}

// 树结点的定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() { }
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}