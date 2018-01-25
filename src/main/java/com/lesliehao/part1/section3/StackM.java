package com.lesliehao.part1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * DESC: 下压栈（先进后出）
 * Created by Hh on 2018/1/25
 */
public class StackM {
    static Scanner scanner = new Scanner(System.in);

    static void test1() {
        Stack<Integer> stack = new Stack<>();
        while (stack.size() < 5) {
            stack.push(StdIn.readInt());
        }
        stack.forEach(integer -> StdOut.println(integer)); //顺序

        // 先进后出
        while (!stack.isEmpty())
            StdOut.println(stack.pop());
    }

    /**
     * Java 是如何完成多项式运算的
     */
    static void test2() {
        // 运算符栈
        Stack<String> ops = new Stack<>();
        // 数值栈
        Stack<Double> vals = new Stack<>();
        // 运算式
        String str = "(1+((2+3)*(4*5)))";
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            switch (c) {
                case "(":
                    break;
                // 运算符直接压栈
                case "+":
                case "-":
                case "*":
                case "/":
                    ops.push(c);
                    break;
                case ")":
                    // 括号结束 计算括号内的值 然后压栈
                    String c2 = ops.pop();
                    double val = vals.pop();
                    switch (c2) {
                        case "+":
                            val = vals.pop() + val;
                            break;
                        case "-":
                            val = vals.pop() - val;
                            break;
                        case "*":
                            val = vals.pop() * val;
                            break;
                        case "/":
                            val = vals.pop() / val;
                            break;
                    }
                    vals.push(val);
                    break;
                default:
                    vals.push(Double.valueOf(c));
                    break;

            }
        }
        System.out.println(vals.pop());
    }

    /**
     * 自定义简单 栈
     */
    static void test3() {
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(100);
        while (!scanner.hasNext("0")) {
            String str = scanner.next();
            if (!str.equals("-")) {
                stack.push(str);
            } else {
                StdOut.println(stack.pop());
            }
        }
        StdOut.println(stack.size());
    }

    public static void main(String[] args) {
//        test2();
        test3();
    }
}
