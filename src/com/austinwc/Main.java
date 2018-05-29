package com.austinwc;


import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> myQ = new ArrayDeque<>();
        myQ.add(1);
        System.out.println(myQ.size());
    }
}
