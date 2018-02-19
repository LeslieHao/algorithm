package com.lesliehao.practice;

import org.junit.Test;

/**
 * DESC: 归并排序
 * Created by Hh on 2018/2/17
 */
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo,mid, hi);
    }


    private static void merge(Comparable[] arr, int lo,int mid, int hi) {
        int i = lo;
        int j = mid + 1; // 中点只会偏左 所以+1
        // 复制数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        for (int k = lo; k <= hi; k++) {
            // 左半边用尽
            if (i > mid) arr[k] = aux[j++];
            // 右半边用尽
            else if (j > hi) arr[k] = aux[i++];

            else if (less(aux[j],aux[i])) arr[k] = aux[j++];

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
    public void test(){
        Integer[] arr = {1, 2, 5, 6, 1, 2, 3, 5};
        sort(arr);
        show(arr);
    }
}
