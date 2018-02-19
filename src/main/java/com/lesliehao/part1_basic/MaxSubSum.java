package com.lesliehao.part1_basic;

import org.junit.Test;

/**
 * DESC: 最大子序列
 * 在线代理
 * 从头开始向后累加
 * 如果thisSum<0 将thisSum 置零
 * 如果 thisSum>maxSum 更新maxSum
 * Created by Hh on 2018/2/18
 */
public class MaxSubSum {

    int maxSubSum(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum < 0) thisSum = 0;
            else if (thisSum > maxSum) maxSum = thisSum;
        }
        return maxSum;
    }

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 5, -1, -2 - 8,12};
        System.out.println(maxSubSum(arr));

    }
}
