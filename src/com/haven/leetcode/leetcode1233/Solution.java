package com.haven.leetcode.leetcode1233;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haven
 * @ClassName: Solution
 * @Description
 * @date 2022/9/26 10:14
 * @since JDK 1.8
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        final String[] fatherFolder = {"none"};
        return Arrays.stream(folder).sorted().filter(s -> {
            if(s.indexOf(fatherFolder[0]) == 0) {
                return false;
            } else {
                fatherFolder[0] = s + "/";
                return true;
            }
        }).collect(Collectors.toList());
    }
}
