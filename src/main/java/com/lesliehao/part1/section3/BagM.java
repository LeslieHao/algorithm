package com.lesliehao.part1.section3;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * DESC: 背包
 * 一种不支持从中删除元素的集合数据类型。
 * 无序
 * Created by Hh on 2018/1/24
 */
public class BagM {

    /**
     * 平均值&标准差
     * @param args
     */
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (numbers.size()<5) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;
        sum = 0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }

        double std = Math.sqrt(sum / (N - 1));

        System.out.println("平均值：" + mean);
        System.out.println("标准差：" + std);
    }
}
