package com.lesliehao.part1_basic.section3.linked;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * DESC: 逆序链表
 * Created by Hh on 2018/2/27
 */
public class LinkAlgorithm {

    public static void main(String[] args) {
//        Node root = getLink();
//        showLink(root);
//        Node toor = reverse(root);
//        showLink(toor);
//        reverseOut(root);
        Node t1 = getLink();
//        Node t2 = getLink();
//        System.out.println(isIntersect(t1, t2));
//        System.out.println(isIntersect2(t1, t2));
//        System.out.println(findJoinNode(t1, t2).element);
//        Node t = merge(t1, t2);
//        showLink(t);
        Node t = KthNodeFormEnd(t1, 3);
        System.out.println(t.element);
    }


    /**
     * 顺序打印链表
     *
     * @param root
     */
    private static void showLink(Node root) {
//        while (root != null) {
//            root.visit();
//            root = root.next;
//        }
//        System.out.println();

        // 递归实现
        if (root != null) {
            root.visit();
            showLink(root.next);
        }

        return;
    }

    /**
     * 逆序打印链表
     *
     * @param root
     */
    static void reverseOut(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        while (!stack.isEmpty()) {
            stack.pop().visit();
        }
    }

    /**
     * 递归构造链表
     */
    static Scanner sc = new Scanner(System.in);

    static Node getLink() {
        int num = sc.nextInt();
        if (num != -1) {
            Node node = new Node(num);
            node.next = getLink();
            return node;
        }
        return null;
    }

    /**
     * 逆序
     *
     * @param root
     * @return
     */
    static Node reverse(Node root) {
        Node pre = root;
        Node cur = pre.next;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        root.next = null; // 原头结点变为尾结点
        return pre;
    }

    /**
     * 链表是否相交
     * 遍历看两个链表的尾节点是否相等
     *
     * @param t1
     * @param t2
     */
    static boolean isIntersect(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return false;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        while (t1.next != null) {
            t1 = t1.next;
        }
        while (t2.next != null) {
            t2 = t2.next;
        }
        return t1.element == t2.element;
    }


    /**
     * 找交点
     * 找出长度差hi
     * 让长链表先走hi 次，
     * 然后两表同时走，碰到相等的就是交点
     */
    static Node findJoinNode(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return null;
        }
        int h1 = 1;
        int h2 = 1;
        Node t = t1;
        while (t.next != null) {
            t = t.next;
            h1++;
        }
        t = t2;
        while (t.next != null) {
            t = t.next;
            h2++;
        }
        return h1 > h2 ? getNode(h1, t1, h2, t2) : getNode(h2, t2, h1, t1);
    }

    private static Node getNode(int maxH, Node maxT, int h, Node t) {
        int hi = Math.abs(maxH - h);
        while (hi-- > 0) {
            maxT = maxT.next;
        }
        while (maxT != null && t != null) {
            if (maxT.element == t.element) {
                return t;
            } else {
                maxT = maxT.next;
                t = t.next;
            }
        }
        return null;
    }

    /**
     * 判断链表是否相交
     * 两个链表接在一起，从第二个链表头开始遍历，如果回到表头，则相交
     *
     * @return
     */
//    static boolean isIntersect2(Node t1, Node t2) {
//
//    }

    /**
     * 合并两个有序链表
     * 递归实现
     */
    static Node merge(Node t1, Node t2) {
        if (t1 == null&&t2!=null) {
            return t2;
        } else if (t2 == null && t1 != null) {
            return t1;
        } else if (t1 == null && t2 == null) {
            return null;
        }
        Node head = null;
        if ((Integer) t1.element < (Integer) t2.element) {
            head = t1;
            head.next = merge(head.next, t2);
        } else {
            head = t2;
            head.next = merge(t1, head.next);
        }
        return head;
    }

    /**
     * 倒数第k 个节点
     * 两个指针，p1 先走k-1 步，然后p1 p2 同时走，p1 到达尾结点时，p2 所在的点就是要找的节点
     */
    static Node KthNodeFormEnd(Node t, int k) {
        Node root = t;
        int n = k;
        while (t != null&&k>1) {
            k--;
            t = t.next;
        }
        while (t.next != null) {
            root = root.next;
            t = t.next;
        }
        return root;
    }

    static class Node<T> {
        T element;

        Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        void visit() {
            System.out.print(element + " ");
        }
    }
}
