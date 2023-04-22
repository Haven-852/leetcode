package com.haven.leetcode.leetcode2283;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            //将字符转为整形
            //也可以使用(int)string.charAt(i)
            h.put(digit, h.getOrDefault(digit, 0) + 1);
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
        }
        for (int i = 0; i < n; i++) {
            int v = num.charAt(i) - '0';
            if (h.getOrDefault(i, 0) != v) {
                return false;
            }
        }
        return true;
    }
}
