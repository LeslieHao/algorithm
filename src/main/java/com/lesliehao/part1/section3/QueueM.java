package com.lesliehao.part1.section3;


import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

/**
 * DESC: 先进先出队列（FIFO）
 * Created by Hh on 2018/1/24
 */
public class QueueM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new Queue<>();
        while (q.size() < 5) {
            q.enqueue(in.nextInt());
        }
        int n = q.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = q.dequeue();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
