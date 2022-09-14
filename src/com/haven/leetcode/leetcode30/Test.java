package com.haven.leetcode.leetcode30;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s="";
        String[] words={};
        Solution solution = new Solution();
        List<Integer> substring = solution.findSubstring(s, words);
        for (int i:substring){
            System.out.println(i);
        }

    }
}
