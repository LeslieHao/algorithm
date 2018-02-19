package com.lesliehao.practice;

import org.junit.Test;


/**
 * DESC:
 * Created by Hh on 2018/2/3
 */
public class BinarySearch {


    int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
        int mid = (lo + hi) / 2;
            if (arr[mid] > key) hi = mid - 1;
            else if (arr[mid] < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5, 7, 8, 10};
        System.out.println(binarySearch(arr, 1));
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(binarySearch(arr, arr[i]));
        }

    }
}
