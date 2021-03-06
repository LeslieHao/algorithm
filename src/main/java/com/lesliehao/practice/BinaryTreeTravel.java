package com.lesliehao.practice;

import com.lesliehao.part1_basic.section3.linked.Node;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * DESC: 二叉树遍历
 * Created by Hh on 2018/2/25
 */
public class BinaryTreeTravel {

    @Test
    public void test() {
        Node root = getTree();
        System.out.println("先序遍历");
        preOrder(root);
        System.out.println();
        preOrder1(root);
        System.out.println();

        System.out.println("中序遍历");
        inOrder(root);
        System.out.println();
        inOrder1(root);
        System.out.println();

        System.out.println("后序遍历");
        afterOrder(root);
        System.out.println();
        afterOrder1(root);
        System.out.println();

        System.out.println("层序遍历");
        tierOrder(root);
        System.out.println();
        tierOrder1(root);
        System.out.println();

        System.out.println();
        System.out.println("深度=" + getDepth(root));
        System.out.println("深度=" + getDepth1(root));
        System.out.println("宽度=" + getMaxWidth(root));
    }

//======================================= 递归 =================================================


    /**
     * 前序遍历递归实现
     */
    void preOrder(Node t) {
        if (t != null) {
            t.visit();
            preOrder(t.left);
            preOrder(t.right);
        }

    }

    /**
     * 中序遍历递归实现
     */
    void inOrder(Node t) {
        if (t != null) {
            inOrder(t.left);
            t.visit();
            inOrder(t.right);
        }
    }

    /**
     * 后序遍历递归实现
     */
    void afterOrder(Node t) {
        if (t != null) {
            afterOrder(t.left);
            afterOrder(t.right);
            t.visit();
        }
    }


    /**
     * 层序遍历
     */
    void tierOrder(Node t) {
        if (t == null) {
            return;
        }
        int depth = getDepth(t);
        for (int i = 1; i <= depth; i++) {
            tierOrder(t, i);
        }
    }

    private void tierOrder(Node t, int level) {
        if (t == null || level == 0) {
            return;
        }
        if (level == 1) {
            t.visit();
        }
        tierOrder(t.left, level - 1);
        tierOrder(t.right, level - 1);
    }

    /**
     * 递归获取二叉树深度
     */
    int getDepth(Node t) {
        if (t == null) return 0;
        int l = getDepth(t.left);
        int r = getDepth(t.right);
        return Math.max(l, r) + 1;
    }

    // ======================================= 非递归 =================================================

    void preOrder1(Node t) {
        Stack<Node> stack = new Stack<>();
        while (t != null || !stack.empty()) {
            while (t != null) {
                t.visit();
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty()) {
                t = stack.pop();
                t = t.right;
            }
        }
    }

    void inOrder1(Node t) {
        Stack<Node> stack = new Stack<>();
        while (t != null || !stack.empty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty()) {
                t = stack.pop();
                t.visit();
                t = t.right;
            }
        }
    }

    void afterOrder1(Node t) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();
        while (t != null || !stack.empty()) {
            if (t != null) {
                stack.push(t);
                output.push(t);
                t = t.right;
            } else {
                t = stack.pop();
                t = t.left;
            }
        }

        while (!output.empty()) {
            output.pop().visit();
        }
    }

    void tierOrder1(Node t) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            t = queue.poll();
            t.visit();
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
    }

    int getDepth1(Node t) {
        Queue<Node> q = new LinkedList<>();
        int tier = 0;
        q.add(t);
        while (!q.isEmpty()) {
            int len = q.size();
            tier++;
            while (len-- > 0) {
                t = q.poll();
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
        }
        return tier;
    }

    int getMaxWidth(Node t) {
        Queue<Node> q = new LinkedList<>();
        int maxWidth = 0;
        q.add(t);
        while (!q.isEmpty()) {
            int len = q.size();
            maxWidth = Math.max(len, maxWidth);
            while (len-- > 0) {
                t = q.poll();
                if (t.left!=null) q.add(t.left);
                if (t.right!=null) q.add(t.right);
            }
        }

        return maxWidth;
    }

    /**
     * 构造一棵树
     * 0
     * /   \
     * 1       2
     * /   \    /  \
     * 3    4   5    6
     *
     * @return
     */
    private Node getTree() {
        int num = 10;
        Node<Integer>[] nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node<>(i);
        }
        Node<Integer> root = nodes[0];
        root.left = nodes[1];
        root.right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];
        nodes[6].left = nodes[7];
        nodes[6].right = nodes[8];

        return root;
    }

    static class Node<T> {
        T element;

        Node<T> left;

        Node<T> right;

        Node(T element) {
            this.element = element;
        }

        void visit() {
            System.out.print(element + " ");
        }
    }

}
