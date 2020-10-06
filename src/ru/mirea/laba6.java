package ru.mirea;

import java.util.Arrays;

class Laba6Test {
    public static void main(String[] args) {
        Student[] arr1 = new Student[10];
        Student[] arr2 = new Student[10];
        Student[] arr31 = new Student[10];
        Student[] arr32 = new Student[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Student();
            arr2[i] = new Student();
            arr31[i] = arr1[i];
            arr32[i] = arr2[i];
        }
        System.out.println("Массив №1");
        System.out.println(ArrToStr(arr1));
        System.out.println("Массив №2");
        System.out.println(ArrToStr(arr2));
        Sort1(arr1, 1, arr1.length);
        Sort2(arr2, 0, arr2.length - 1);
        Student[] arr3 = Sort3(Merge(arr31, arr32));
        System.out.println("Отсортированный массив №1 (сортировка вставкой)");
        System.out.println(ArrToStr(arr1));
        System.out.println("Отсортированный массив №2 (быстрая сотрировка)");
        System.out.println(ArrToStr(arr2));
        System.out.println("Отсортированный массив №3 (объеденённый из №1 и №2)");
        System.out.println(ArrToStr(arr3));
    }
    static String ArrToStr(Object[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length - 1; i++)
            s += arr[i] + ", ";
        s += arr[arr.length - 1] + "]";
        return s;
    }
    static void Sort1(Student[] arr, int start, int end) {
        int i, j;
        Student change;
        for (i = start; i < end; i++) {
            change = arr[i];
            for (j = i - 1; j >= start - 1 && arr[j].compareTo(change) == 1; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = change;
        }
    }
    static void Sort2(Student[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && arr[i].compareTo(arr[cur]) == -1)
                i++;
            while (j > cur && arr[cur].compareTo(arr[j]) == -1)
                j--;
            if (i < j) {
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        Sort2(arr, start, cur);
        Sort2(arr, cur + 1, end);
    }
    public static Student[] Sort3(Student[] arr) {
        if (arr.length < 2)
            return arr;
        int m = arr.length / 2;
        Student[] arr1 = Arrays.copyOfRange(arr, 0, m);
        Student[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return Merge(Sort3(arr1), Sort3(arr2));
    }
    public static Student[] Merge(Student[] arr1, Student arr2[]) {
        int n = arr1.length + arr2.length;
        Student[] arr = new Student[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++)
            if (i1 == arr1.length)
                arr[i] = arr2[i2++];
            else if (i2 == arr2.length)
                arr[i] = arr1[i1++];
            else if (arr1[i1].compareTo(arr2[i2]) == -1)
                arr[i] = arr1[i1++];
            else
                arr[i] = arr2[i2++];
        return arr;
    }

}

