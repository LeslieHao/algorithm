package com.lesliehao.part2_sort.section3;

import org.junit.Test;

import java.util.Arrays;

/**
 * DESC:堆排序
 * 1.先构造堆
 * 2.然后首尾交换-下沉头-循环
 * Created by Hh on 2018/2/22
 */
public class HeapSort {

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 由上而下的堆有序化（下沉）
     *
     * @param k
     */
    private void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public void sort(Comparable[] a) {
        int N = a.length - 1;
        // 循环下沉 构造堆
        for (int k = N / 2; k >= 0; k--) {
            sink(a, k, N);
        }
        // 首尾交换 下沉头结点
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    @Test
    public void test() {
        Integer[] a = {5, 1, 3, 5, 7, 2, 3, 5, 7, 7, 4, 5, 8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
