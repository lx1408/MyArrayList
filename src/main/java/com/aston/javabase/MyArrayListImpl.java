package com.aston.javabase;

import java.util.Arrays;
import java.util.Comparator;

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
     *
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
    public void sort(Comparator<? super E> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Рекурсивно выполняет сортировку подмассива с помощью алгоритма быстрой сортировки.
     * Этот метод разбивает массив на две части относительно опорного элемента и сортирует их.
     *
     * @param low       индекс начала подмассива, который нужно отсортировать.
     * @param high      индекс конца подмассива, который нужно отсортировать.
     * @param comparator компаратор, который определяет порядок сортировки.
     */
    private void quickSort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);  // Сортировка левой части
            quickSort(pivotIndex + 1, high, comparator); // Сортировка правой части
        }
    }

    /**
     * Разделяет массив на две части относительно опорного элемента и возвращает индекс опорного элемента.
     * Элементы, меньшие или равные опорному элементу, будут в левой части, а большие — в правой.
     *
     * @param low       индекс начала подмассива для разделения.
     * @param high      индекс конца подмассива для разделения.
     * @param comparator компаратор, который определяет порядок сортировки.
     * @return индекс опорного элемента после его размещения на своём месте.
     */
    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = values[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (comparator.compare(values[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами два элемента в массиве.
     *
     * @param i индекс первого элемента для обмена.
     * @param j индекс второго элемента для обмена.
     */
    private void swap(int i, int j) {
        E temp = values[i];
        values[i] = values[j];
        values[j] = temp;
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

