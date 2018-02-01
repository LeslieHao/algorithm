package com.lesliehao.part2_sort.section1;

/**
 * DESC: 插入排序
 * 从位置1 开始 向前比较 插入
 * 时间复杂度：
 * 最优情况 O(n)
 * 最坏情况 O(n^2)
 *
 * 插入排序对部分有序数组很有效
 *  数组中每个元素距离它的最终位置都不远
 *  一个有序的大数组接一个小数组
 *  数组中只有几个元素的位置不正确
 * Created by Hh on 2018/2/1
 */
public class InsertionSort {
    /**
     * 插入排序
     * 从index 1 开始，向前插入
     * 如果大于前一个数就交换位置
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length; // 数组长度
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0&&less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
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
            if (less(a[i],a[i-1])) return false;
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
