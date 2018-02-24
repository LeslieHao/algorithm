package com.lesliehao.part4_tree;

/**
 * DESC: 二叉查找树的实现
 * Created by Hh on 2018/2/24
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMin(root).element;
    }

    public AnyType findMax()throws Exception  {
        if (isEmpty()) throw  new Exception();
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {

    }


    /**
     * 递归查找
     *
     * @param x
     * @param t
     * @return
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) return contains(x, t.left);
        else if (compareResult > 0) return contains(x, t.right);
        else return true;
    }

    /**
     * 只要有左儿子就向左进行。终止点就是最小元素
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        else return findMin(t.left);
    }

    /**
     * 只要有右儿子就向右进行。终点点就是最大元素
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        // 递归实现

//        if (t==null) return null;
//        else if (t.right==null) return t;
//        else return findMax(t.right);

        // 非递归实现
        if (t != null)
            while (t.right != null) {
                t = t.right;
            }
        return t;
    }

    /**
     * 类似contanis 的过程，递归向下移动，直到遇到一个空的指针，插入的位置就只指针指向的位置
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        // 空树 直接插入
        if (t == null) return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) t.left = insert(x, t.left);

        else if (compareResult > 0) t.right = insert(x, t.right);

        else {
            // 重复元素的插入可以通过在节点记录中保留一个附加区域以只是发生的频率来处理。
            // 这对整个树增加了某些附加空间，但是却比将重复元素放入树中要好，因为那样会使树的深度变得很大。
        }
        return t;
    }

    /**
     * 分三种情况：
     * 1.如果节点是一片叶子，直接删除
     * 2.如果节点有一个儿子，则该节点可以在其父节点调整自己的链绕过该节点后被删除。
     * 3.如果节点有两个儿子，一般的策略是用其右子树的最小数据代替该节点，并递归删除最小节点
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return t;

        int cpResult = x.compareTo(t.element);

        if (cpResult < 0){
            t.left = remove(x, t.left);
        } else if (cpResult > 0){
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            // 两个孩子
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }


    /**
     * 二叉查找树的节点
     *
     * @param <AnyType>
     */
    private static class BinaryNode<AnyType> {
        AnyType element;

        BinaryNode<AnyType> left;

        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element) {
            this.element = element;
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

}
