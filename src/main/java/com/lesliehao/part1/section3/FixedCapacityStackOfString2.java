package com.lesliehao.part1.section3;

/**
 * DESC: 泛型
 * Created by Hh on 2018/1/25
 */
public class FixedCapacityStackOfString2<Item> {

    private Item[] a;

    private int N;

    public FixedCapacityStackOfString2(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item o) {
        a[N++] = o;
    }
    public Item  pop(){
        return a[--N];
    }
}

