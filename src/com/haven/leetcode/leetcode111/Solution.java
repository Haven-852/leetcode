package com.haven.leetcode.leetcode111;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left ==null && root.right==null){
            return 1;
        }
        int min_deepin=Integer.MAX_VALUE;
        if (root.left!=null){
            min_deepin= Math.min(minDepth(root.left),min_deepin);
        }
        if (root.right!=null){
            min_deepin=Math.min(minDepth(root.right),min_deepin);
        }
        return min_deepin+1;
    }
    public static void main(String[] args) {
        int [] rootArray={2,0,3,0,4,0,5,0,6, Integer.parseInt(null)};
        TreeNode root=new TreeNode(3);
        TreeNode root1=new TreeNode(9);
        root.left=root1;
        TreeNode root2=new TreeNode(20);
        root.right=root2;
        TreeNode root5=new TreeNode(15);
        root2.left=root5;
        TreeNode root6=new TreeNode(7);
        root2.right=root6;
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
        System.out.println(Integer.parseInt(null));
    }
}
