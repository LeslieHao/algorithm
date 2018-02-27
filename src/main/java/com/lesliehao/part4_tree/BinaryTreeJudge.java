package com.lesliehao.part4_tree;

import com.lesliehao.practice.BinaryTreeTravel;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DESC: 二叉树其他相关算法
 * Created by Hh on 2018/2/26
 */
public class BinaryTreeJudge {

    @Test
    public void test() {
        Node root = getTree();
        System.out.println(completeJudge(root));
    }

    /**
     * 判断一棵树是否是完全二叉树
     * 层序遍历
     * 1.当检查到某个节点只有右儿子时，退出
     * 2.当检查到某个节点没有右儿子，必须保证接下去所有的节点都是叶子节点，才是完全二叉树
     *
     * @param t
     */
    boolean completeJudge(Node t) {
        Queue<Node> q = new LinkedList<>();
        boolean leaf = false;// 标记剩下的节点是否需要全是叶子节点
        q.add(t);
        while (!q.isEmpty()) {
            Node node = q.poll();
            Node l = node.left;
            Node r = node.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                // 如果之前的节点存在没有有孩子的节点, 且当前节点有左孩子或右孩子，返回false
                // 如果当前节点有右孩子却没有左孩子，返回false
                return false;
            } else {
                if (l != null) {
                    q.add(l);
                }
                if (r != null) {
                    q.add(r);
                } else {
                    // 如果当前节点没有右孩子，那么之后遍历的节点必须是叶子节点
                    leaf = true;
                }
            }
        }
        return true;
    }

    /**
     * 判断二叉树是否镜面对称
     *
     * @param r1
     * @param r2
     * @return
     */
    boolean isSymmetrical(Node r1, Node r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else {
            return r1.element == r2.element
                    && isSymmetrical(r1.left, r2.right)
                    && isSymmetrical(r1.right, r2.left);
        }
    }

    boolean isSymmetrical(Node root) {
        if (root == null) {
            return true; // 空树
        }
        return isSymmetrical(root.left, root.right);
    }


    /**
     * 判断二叉树是否相等
     *
     * @param t1
     * @param t2
     * @return
     */
    boolean isEqual(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true; // 两棵空树
        } else if (t1 == null || t2 == null) {
            return false; // 一棵为空
        } else if (t1.element == t2.element) {
            return isEqual(t1.left, t2.left)
                    && isEqual(t1.right, t2.right);
        } else {
            return false;
        }

    }


    void tierOrder1(Node t) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            Node thisNode = queue.poll();
            thisNode.visit();
            if (thisNode.left != null) queue.add(thisNode.left);
            if (thisNode.right != null) queue.add(thisNode.right);
        }
    }

    /**
     * 递归构建一棵二叉树
     */
    Scanner sc = new Scanner(System.in);

    Node Construt(Node node) {
        String temp = sc.next();
        if (temp.trim().equals("#")) {
            return null;
        } else {
            node = new Node(temp);
            node.left = Construt(node.left);
            node.right = Construt(node.right);
            return node;
        }
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
        nodes[3].left = nodes[7];
        nodes[4].left = nodes[8];
//        nodes[6].left = nodes[7];
//        nodes[6].right = nodes[8];

        return root;
    }

    static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }

        void visit() {
            System.out.print(element + " ");
        }

    }
}
