package com.lesliehao.part2_sort.section2;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Arrays;

/**
 * DESC: 快速排序
 * Created by Hh on 2018/2/21
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // 切分
        sort(a, lo, j - 1); // 左半部分排序
        sort(a, j + 1, hi); // 右半部分排序
    }

    /**
     * 切分
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1] a[i] a[i+1..hi]
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break; // a[i] < 切分值时，增大i
            while (less(v, a[--j])) if (j == lo) break; // a[j] > 切分值时，减小j
            if (i >= j) break; // 指针相遇 切分结束（切分值 保留在a[j] 中）
            exch(a, i, j);
        }
        exch(a, lo, j); // 将v = a[j] 放入正确的位置
        System.out.println(Arrays.toString(a));
        System.out.println(j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void test() {
        Integer[] arr = {3, 4, 1, 2, 5, 9, 7};
        sort(arr);
    }
}
