package com.haven.leetcode.leetcode239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
/*    我们将执行过程进行拆解。

            1.想将我们第一个窗口的所有值存入单调双端队列中，单调队列里面的值为单调递减的。如果发现队尾元素小于要加入的元素，则将队尾元素出队，直到队尾元素大于新元素时，再让新元素入队，目的就是维护一个单调递减的队列。

            2.我们将第一个窗口的所有值，按照单调队列的规则入队之后，因为队列为单调递减，所以队头元素必为当前窗口的最大值，则将队头元素添加到数组中。

            3.移动窗口，判断当前窗口前的元素是否和队头元素相等，如果相等则出队。

            4.继续然后按照规则进行入队，维护单调递减队列。

            5.每次将队头元素存到返回数组里。

            6.返回数组

            利用双端队列，来解决内存不足的问题，解决类Solution的当中遇见大数组或者内存不足的情况，
            保持双端队列当中维持双端队列的单调递减的顺序
    */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if (len == 0) {
                return nums;
            }
            int[] arr = new int[len - k + 1];
            int arr_index = 0;
            //我们需要维护一个单调递增的双向队列
            Deque<Integer> deque = new LinkedList<>();
            //先将第一个窗口的值按照规则入队
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
                deque.offerLast(nums[i]);
            }
            //存到数组里，队头元素
            arr[arr_index++] = deque.peekFirst();
            //移动窗口
            for (int j = k; j < len; j++) {
                //对应咱们的红色情况，则是窗口的前一个元素等于队头元素
                if (nums[j - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                    deque.removeLast();
                }
                deque.offerLast(nums[j]);
                arr[arr_index++] = deque.peekFirst();
            }
            return arr;
        }


}
