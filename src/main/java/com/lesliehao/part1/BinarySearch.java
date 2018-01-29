package com.lesliehao.part1;

import org.junit.Test;

/**
 * DESC: 二分查找
 * Created by Hh on 2018/1/29
 */
public class BinarySearch {
    public static int search(int key, int[] arr) {

        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            // 中点
            int mid = (hi + lo) / 2;
            if (arr[mid]>key)  hi = mid-1;
            else if(arr[mid] <key) lo = mid+1;
            else  return mid;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};
        System.out.println(search(11,arr));
    }
}
