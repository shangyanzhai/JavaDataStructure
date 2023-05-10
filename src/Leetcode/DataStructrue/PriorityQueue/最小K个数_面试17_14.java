package Leetcode.DataStructrue.PriorityQueue;

import java.util.*;

/**
 * 面试题 17.14. 最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最小K个数_面试17_14 {
    //方法一 直接建 arr.length 大小的堆
//    public int[] smallestK(int[] arr, int k) {
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
//        for(int i : arr){
//            pQueue.offer(i);
//        }
//
//        int[] arr1 = new int[k];
//        for(int i = 0;i < k;i++){
//            arr1[i] = pQueue.poll();
//        }
//
//        return arr1;
//    }
    //方法二 只建 k 大小的堆，以防止数组大小过大
    static class ReversedComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        // 1. 要找出最小的 Top K 元素，需要大堆（自然顺序大的优先出队列）
        // 2. JDK 提供的 PriorityQueue 是 小堆
        // 3. 通过重新定义 int 的顺序，即 9 小于 8 小于 7 小于 6 ...
        ReversedComparator c = new ReversedComparator();
        PriorityQueue<Integer> pq = new PriorityQueue(c);
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int top = pq.peek();
            if (arr[i] < top) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
