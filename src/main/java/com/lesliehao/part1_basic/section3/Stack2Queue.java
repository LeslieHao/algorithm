package com.lesliehao.part1_basic.section3;

import org.junit.Test;

import java.util.Stack;

/**
 * DESC: 两个栈实现队列
 * Created by Hh on 2018/2/27
 */
public class Stack2Queue {

    /**
     * 入队时，将元素压入s1
     * 出队时，如果s2 非空，弹出s2
     * 否则将s1 倒入s2 弹出
     */

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int i) {
        s1.push(i);
    }


    int pop(){
        if (s2.isEmpty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    @Test
    public void test(){
        Stack2Queue s = new Stack2Queue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        for (int i = 0; i < 2; i++) {
            System.out.println(s.pop());
        }
        System.out.println();
        s.push(5);
        for (int i = 0; i < 3; i++) {
            System.out.println(s.pop());
        }
    }
}
