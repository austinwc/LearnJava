package com.austinwc;


import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> mySet = new LinkedHashSet<>();

        mySet.add(1);
        mySet.add(3);
        mySet.add(5);
        mySet.add(2);

        mySet.remove(5);

        for (Integer x: mySet) {
            System.out.println(x);
        }
    }
}
