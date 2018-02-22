package com.lesliehao.part2_sort.section3;

/**
 * DESC:优先队列
 * Created by Hh on 2018/2/22
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; // 基于堆的完全二叉树

    private int N = 0; // 存储于pq[1..N] 中，pq[0] 没有使用

    public MaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // 拿到最大元素
        exch(1, N--); // 首尾交换
        pq[N + 1] = null; // 防止对象游离
        sink(1); // 下沉1 恢复堆顺序
        return max;
    }


    private boolean less(int i, int j) {
        return pq[1].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 由下至上的堆有序化（上浮）
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上而下的堆有序化（下沉）
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j<N&&less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    public  void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
    }
}
