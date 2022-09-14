package com.haven.leetcode.leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m=words.length;
        int n=words[0].length();
        List<Integer> ans=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (!map.keySet().contains(words[i])){
                map.put(words[i],1);
            }
            else if (map.keySet().contains(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
        }
        for (int i = 0; i < s.length()-m*n+1; i++) {
            String substring = s.substring(i, i + m * n);
            if(isInclude(map,substring,n,m)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean isInclude(Map<String,Integer> map,String s,int n,int m){
        Map<String,Integer> map1=new HashMap<>();
        for (int i = 0; i <m ; i++) {
            String substr=s.substring(i*n,(i+1)*n);
            if (!map1.containsKey(substr)){
                map1.put(substr,1);
            }
            else if (map1.containsKey(substr)){
                map1.put(substr,map1.get(substr)+1);
            }
        }
        for (String str :map.keySet()){
            if (map1.get(str)!=map.get(str)){
                return false;
            }

        }
        return true;
    }

}
