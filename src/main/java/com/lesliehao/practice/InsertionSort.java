package com.lesliehao.practice;

/**
 * DESC: 插入排序
 * Created by Hh on 2018/2/17
 */
public class InsertionSort {

    public static void sort(Comparable[] c) {
        int N = c.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0&&less(c[j],c[j-1]) ; j--) {
               exch(c,j,j-1);
            }
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
        for (int i = 1; i < c.length-1; i++) {
            if (less(c[i],c[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 2, 4, 3, 5, 6, 8, 7};
        sort(a);
        show(a);
        System.out.println(isSorted(a));
    }

}
