package com.haven.leetcode.leetcode94;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    public void inorder(TreeNode root,List<Integer> ans){
        if (root==null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}
