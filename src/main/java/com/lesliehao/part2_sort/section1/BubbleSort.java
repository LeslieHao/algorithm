package com.lesliehao.part2_sort.section1;

import edu.princeton.cs.algs4.FFT;

import java.util.Arrays;

/**
 * DESC: 冒泡排序
 * 每轮循环将最大的数浮动到最右侧
 * Created by Hh on 2018/2/21
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j + 1, j);
                    // 一次内循环 未执行一次交换操作（排序已经完成）
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
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

    public static void main(String[] args) {
        Integer arr[] = {1, 5, 4, 7, 8, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
