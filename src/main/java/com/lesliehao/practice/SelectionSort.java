package com.lesliehao.practice;

import org.junit.Test;

/**
 * DESC:
 * Created by Hh on 2018/2/17
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param c
     */
    public static void sort(Comparable[] c) {
        int N = c.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(c[j],c[minIndex])) minIndex = j;
            }
            exch(c,minIndex,i);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] c, int i, int j) {
        Comparable a = c[i];
        c[i] = c[j];
        c[j] = a;
    }

    public static void show(Comparable[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static boolean isSorted(Comparable[] c) {
        for (int i = 1; i < c.length; i++) {
            if (less(c[i],c[i-1])) return false;
        }
        return true;
    }

    @Test
    public void test(){
        Integer[] arr = {1, 2, 3, 5, 1, 2, 7, 3, 54, 7};
        sort(arr);
        System.out.println(isSorted(arr));
        show(arr);
    }
}
