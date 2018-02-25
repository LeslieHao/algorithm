package com.lesliehao.part4_tree;

/**
 * DESC:AVL 树的节点
 * Created by Hh on 2018/2/25
 */
public class AvlNode<AnyType> {

    AnyType element;

    AvlNode<AnyType> left;

    AvlNode<AnyType> right;

    int height;

    public AvlNode(AnyType element) {
        this(element,null,null);
    }

    public AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
