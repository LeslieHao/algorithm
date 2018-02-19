package com.lesliehao.part1_basic;

/**
 * DESC:最大公约数
 * 欧几里得算法
 * Created by Hh on 2018/2/3
 */
public class OJLDgcd {

    public int gcd(int p, int q) {
        if (q==0) return p;
        int r = p % q;
        return gcd(q,r);
    }

}
