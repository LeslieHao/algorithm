package com.lesliehao.part1_basic.section3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DESC: 两个队列实现栈
 * Created by Hh on 2018/2/27
 */
public class Queue2Stack {

    /**
     * push：如果两个队列都为空，q1 入队；否则就优先q1 的插入到非空队列
     * pop：把非空的队列元素出队到另一个队列，直到剩下一个元素，返回（非空队的队尾）
     */

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int i){
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(i);
        } else if (q1.isEmpty()) {
            q2.offer(i);
        } else {
            q1.offer(i);
        }
    }

    int poll() {
        if (!q1.isEmpty() && q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else if (q1.isEmpty() && !q2.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
        return -1;
    }


    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(poll());
        }
    }

}
