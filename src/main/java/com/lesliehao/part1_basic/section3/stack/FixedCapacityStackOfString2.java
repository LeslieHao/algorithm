package com.lesliehao.part1_basic.section3.stack;

import java.util.Iterator;

/**
 * DESC: 泛型 栈
 * 二倍扩容 并保证使用率不低于四分之一
 * 迭代器
 * Created by Hh on 2018/1/25
 */
public class FixedCapacityStackOfString2<Item> implements Iterable{

    private Item[] a;

    private int N; // 元素个数

    public FixedCapacityStackOfString2(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item o) {
        // 扩容
        if (N == a.length) resize(a.length * 2);
        a[N++] = o;
    }

    /**
     * 保证使用率不低于四分之一
     */
    public Item pop() {
        Item item =  a[--N];
        a[N] = null; // 避免对象游离（弹出的对象已经永远不会再被使用了，但是它仍然存在于数组中）
        if (N>0&&N==a.length/4) resize(a.length/2);
        return item;
    }

    /**
     * 调整数组大小
     * @param max
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 先进后出的迭代
     */
    private class ReverseArrayIterator implements Iterator {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Object next() {
            return a[--i];
        }
        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfString2<Integer> stack = new FixedCapacityStackOfString2(2);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        Iterator i = stack.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            stack.pop();
        }
    }
}

