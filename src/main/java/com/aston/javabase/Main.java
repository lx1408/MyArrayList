package com.aston.javabase;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayListImpl<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println((list.get(2)));
        System.out.println(list);
        list.clear();
        System.out.println(list);

    }
}
