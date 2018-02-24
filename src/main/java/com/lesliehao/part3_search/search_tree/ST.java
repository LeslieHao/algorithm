package com.lesliehao.part3_search.search_tree;

/**
 * DESC: 简单的泛型符号表
 * Created by Hh on 2018/2/23
 */
public interface ST<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    // 表中所有键的集合
    Iterable<Key> keys();

}
