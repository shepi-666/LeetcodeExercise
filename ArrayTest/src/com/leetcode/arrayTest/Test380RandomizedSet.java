package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author: DongShaowei
 * @create: 2024-08-16 09:56
 * @description:
 */
public class Test380RandomizedSet {


    @Test
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

}

/**
 * 实现思路：List+HashSet
 */
class RandomizedSet {

    private List<Integer> list;

    private Set<Integer> set;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {

        boolean add = set.add(val);
        if (add) list.add(val);
        return add;

    }

    public boolean remove(int val) {
        boolean remove = set.remove(val);
        if (remove) list.remove(new Integer(val));
        return remove;
    }

    public int getRandom() {
        int randIndex = (int) Math.floor(Math.random() * list.size());
        return list.get(randIndex);
    }
}
