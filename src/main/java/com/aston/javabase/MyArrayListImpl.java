package com.aston.javabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListImpl<E> implements MyArrayList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private E[] values;
    private int size;

    /**
     * Конструктор, который инициализирует массив значений с начальным размером 10.
     * Размер массива увеличивается по мере добавления элементов.
     */
    public MyArrayListImpl() {
        values = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Конструктор, который инициализирует массив заданной длины.
     * @param length необходимый размер массива.
     * Размер массива увеличивается по мере добавления элементов.
     */
    public MyArrayListImpl(int length) {
        values = (E[]) new Object[length];
        size = 0;
    }

    @Override
    public void add(E e) {
        grow();
        values[size++] = e;
    }


    @Override
    public void add(int index, E e) {
        grow();
        System.arraycopy(values, index, values, index + 1, size - index);   //сдвигаем после индекса массив вправо, вставляем элемент по индексу
        values[index] = e;
        size++;
    }

    @Override
    public void remove(int index) {
            if (index<0 || index > (size-1))  throw new ArrayIndexOutOfBoundsException();
            index++;
        System.arraycopy(values,index--,values,index,size-index);
        size--;
    }

    @Override
    public E get(int index) {
        if (index<0 || index > (size-1))  throw new ArrayIndexOutOfBoundsException();
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        values = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void sort() {

    }

    private void grow() {
        if (size == values.length) {
            values = Arrays.copyOf(values, values.length + values.length/2); //увеличим в полтора раза
        }
    }

    public String toString(){
        return Arrays.toString(values);
    }
}