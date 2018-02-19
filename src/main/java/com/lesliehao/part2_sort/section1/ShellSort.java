package com.lesliehao.part2_sort.section1;

import org.junit.Test;

import java.util.Arrays;

/**
 * DESC: 希尔排序
 * Created by Hh on 2018/2/17
 */
public class ShellSort {

    /**
     * 把数组按下标的一定增量分组，对每个分组使用插入排序算法；
     * 随着增量的逐渐减小，每组包含的元素越来越多。
     * 当增量缩小为1时。排序完毕
     *
     * 希尔排序的性能与增量序列的选取有关
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int N = arr.length;
//        int h = N / 2;
        int h = 1;
        while (h<N/3) h = 3*h+1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
            }
//            h = h / 2;
            h= h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i],arr[i-1])) return false;
        }
        return true;
    }

    @Test
    public void test(){
        Integer[] arr = {1, 2, 3, 6, 8, 90, 3, 546, 2, 15, 7, 8};
        sort(arr);
        System.out.println(isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }

}
