package com.lesliehao.part2_sort.section1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * DESC: 选择排序
 * 首先，找到数组中最小的那个元素，然后将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么他就和自己交换）。
 * 再次，在剩下的元素中找到最小元素，与数组第二个元素交换。
 * 直到整个数组排序
 * 时间复杂度 O(n^2)
 * Created by Hh on 2018/2/1
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length; // 数组长度
        // n-1 时 已经排序完毕
        for (int i = 0; i < N-1; i++) {
            int minIndex = i; // 一次向后遍历找到的最小值的index
            for (int j = i + 1; j < N; j++) {
                if (less(a[j],a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a,i,minIndex); // 每次向后遍历后 交换
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // i-1 不出现数组越界
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 5, 1, 2, 7, 3, 54, 7};
//        Integer[] a = {1, 2, 4, 3, 5, 6, 8, 7};
        SelectionSort.sort(arr);
        SelectionSort.show(arr);
        System.out.println(SelectionSort.isSorted(arr));
    }
}
