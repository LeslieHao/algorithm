package com.lesliehao.part1_basic.section3.queue;
import java.util.Iterator;

/**
 * DESC: 先进先出队列
 * Created by Hh on 2018/1/31
 */
public class LinkedQueue<Item> implements Iterable {

    private Node first;

    private Node last;

    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 入队
     * @param item
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        oldLast.next = last;
        N++;
    }

    /**
     * 出队
     * @return
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator {
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

}
