package com.weiyeli.JianZhiOffer.chapter5;

import java.util.*;

/**
 * 最小的K个数
 */
public class GetLeastNumbers_Solution {

    /**
     * 方法1：直接排序，取前面的K个数
     * 时间复杂度：O(nlogN)
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length <= 0 || k > input.length || k <= 0)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }

        return ret;
    }

    /**
     * 构建大小为K的大顶堆
     * 时间复杂度：O(nlogK)
     * 空间复杂度：O(k)
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        if (input == null || input.length <= 0 || k > input.length || k <= 0)
            return new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<Integer> ret = new ArrayList<>(pq);
        return ret;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        if (input == null || input.length <= 0 || k > input.length || k <= 0)
            return new ArrayList<>();

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> list = GetLeastNumbers_Solution2(a, 4);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
