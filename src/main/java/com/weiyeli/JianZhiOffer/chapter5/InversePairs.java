package com.weiyeli.JianZhiOffer.chapter5;

import java.util.Arrays;

/**
 * 数组中的逆序对
 */
public class InversePairs {
    private long ans = 0;

    private int[] aux;  //在外部创建辅助数组，不要在merge()递归函数中创建 ？？？

    private void merge(int[] nums, int l, int mid, int r) {
        aux = Arrays.copyOfRange(nums, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] > aux[j - l]) {
                nums[k] = aux[j - l];
                //如果nums[i] > nums[j]，那么nums[i..mid]都大于nums[j]
                this.ans += mid - i + 1;
                j++;
            } else {
                nums[k] = aux[i - l];
                i++;
            }
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] > nums[mid+1])
            merge(nums, l, mid, r);
    }

    public int InversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return (int) (this.ans % 1000000007);
    }


}
