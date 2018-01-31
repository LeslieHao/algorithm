package com.lesliehao.part1.section3.linked;

import org.junit.Test;

/**
 * DESC:
 * Created by Hh on 2018/1/30
 */
public class ConstructLink {

    @Test
    public void test() {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> last = new Node<>();
        first.item = "how";
        second.item = "r";
        last.item = "u";
        first.next = second;
        second.next = last;
        // 此时 third.next 仍然指向null

        // 表头增加节点
        Node<String> oldFirst = first;
        first = new Node<>();
        first.next = oldFirst;
        first.item = "hello";

//        // 表头删除节点
//        first = second;

        // 表尾插入节点
        Node oldLast = last;
        last = new Node<String>();
        oldLast.next = last;
        last.item = "!!!";


        for (Node x = first; x != null; x = x.next) {
            System.out.print(x.item + "  ");
        }
    }
}
