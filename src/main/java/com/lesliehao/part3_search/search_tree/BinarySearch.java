package com.lesliehao.part3_search.search_tree;

import org.junit.Test;

/**
 * DESC: 二分查找的递归和非递归实现
 * O(logN)
 * Created by Hh on 2018/2/23
 */
public class BinarySearch {


    /**
     * 非递归
     * @param arr
     * @param key
     * @return
     */
    int search(Comparable[] arr, Comparable key) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        // 条件必须包括等于 因为如果查找最大元素 一定会出现lo=hi 的情况。因为mid 始终是小于最大元素的
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int cpResult = arr[mid].compareTo(key);
            if (cpResult > 0) {
                hi = mid - 1;
            } else if (cpResult == 0) {
                return mid;
            } else {
                lo = mid + 1;
            }
//            System.out.println(lo+"  "+mid+"  "+hi);
        }
        return -1;
    }

    /**
     * 递归
     * @param arr
     * @param key
     * @return
     */
    int searchRe(Comparable[] arr, Comparable key) {
        return rank(arr, key, 0, arr.length - 1);
    }

    int rank(Comparable[] arr, Comparable key, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = (lo + hi) / 2;
        int cpResult = arr[mid].compareTo(key);
        if (cpResult < 0) return rank(arr, key, mid + 1, hi);
        else if (cpResult > 0) return rank(arr, key, lo, mid - 1);
        else return mid;
    }

    @Test
    public void test() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 1; i <= 9; i++) {
            System.out.println(searchRe(arr, i));
        }
//        System.out.println(search(arr,11));
    }
}
