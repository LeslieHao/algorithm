package com.lesliehao.part2_sort.section2;

import org.junit.Test;

/**
 * DESC: 自底向上的归并排序
 * 不用递归
 * Created by Hh on 2018/2/19
 */
public class MergeBuSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        aux = new Comparable[N];
        // size = 1,2,4,8....
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo <N-sz ; lo+=sz+sz) {
               merge(arr,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }


    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k < hi; k++) {
            if (i > mid) arr[k] = aux[j++]; // 左半边用完 直接将右半边放入
            else if (j > hi) arr[k] = aux[i++]; // 右半边用完 直接将左半边放入

                // 比较左右两边最左点的大小 将最小数赋值到arr 并右移
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] c, int i, int j) {
        Comparable t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void show(Comparable[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i] + "  ");
        }
    }

    public static boolean isSorted(Comparable[] c) {
        for (int i = 1; i < c.length - 1; i++) {
            if (less(c[i], c[i - 1])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Integer[] arr = {1, 2, 5, 6, 1, 2, 3, 5};
        sort(arr);
        show(arr);
    }
}
