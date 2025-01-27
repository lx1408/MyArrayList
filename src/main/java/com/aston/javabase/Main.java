package com.aston.javabase;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayListImpl<Integer>();
        list.add(8);
        list.add(5);
        list.add(5);
        list.add(2);
        list.remove(3);
        System.out.println(list);
        list.add(1);
        list.add(2,10);
        System.out.println(list);
        list.add(9);
        Comparator<Integer> comparator = (o1, o2) -> (o2-o1);
        list.sort(comparator);
        System.out.println(list);
    }
}
