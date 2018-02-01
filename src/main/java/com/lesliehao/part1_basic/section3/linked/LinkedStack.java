package com.lesliehao.part1_basic.section3.linked;

import java.util.Iterator;

/**
 * DESC: 下压堆栈的链表实现
 * Created by Hh on 2018/1/30
 */
public class LinkedStack<Item> implements Iterable {

    private Node first; // 头节点

    private int N; // size

    @Override
    public Iterator iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Object next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    private void push(Item item) {
        // 表头插入
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        N++;
    }

    private Item pop(){
        // 表头删除
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    private boolean isEmpty(){
        return N == 0;
    }

    private int size(){
        return N;
    }
}
