package com.lesliehao.part3_search;

import org.junit.Test;

import java.util.HashMap;

/**
 * DESC:
 * Created by Hh on 2018/2/23
 */
public class 占位 {

    @Test
    public void test(){
        HashMap<String, String> map= new HashMap<>();
        map.put("1", null);
        map.put("2", null);
        map.put("3", null);
        System.out.println(map.size());
        System.out.println(map.get("5"));
    }
}
