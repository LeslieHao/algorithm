package com.lesliehao.part2_sort.section2;

import org.junit.Test;

import java.util.Arrays;

/**
 * DESC: 三路快速排序（三向切分）
 * Created by Hh on 2018/2/21
 */
public class Quick3WaySort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp<0) exch(a, lt++, i++); // 小于基数的浮动到前面
            else if (cmp>0) exch(a, i, gt--); // 大于基数的浮动到后面
            else i++;
            System.out.println(Arrays.toString(a));
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
    public void test(){
        Integer[] arr = {3, 2, 3, 5, 7, 1, 2, 34, 5, 3, 2, 34, 56};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
