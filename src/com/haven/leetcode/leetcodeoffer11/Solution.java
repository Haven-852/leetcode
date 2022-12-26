package com.haven.leetcode.leetcodeoffer11;

public class Solution {
    public int minArray(int[] numbers) {
        int high=numbers.length-1;
        int low=0;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
