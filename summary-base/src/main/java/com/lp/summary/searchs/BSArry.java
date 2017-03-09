package com.lp.summary.searchs;

/**
 * Created by Administrator on 2017/3/2.
 * 折半查找
 */
public class BSArry {
    public static void main(String[] args) {
        int[] arrays = {1, 4, 7, 10, 12, 14, 15, 18, 22, 25, 27};
        int index = binarySearch(arrays,12);
        System.out.println(arrays[index] == 12);
    }

    public static<T> int binarySearch(Comparable<T>[] values,T key){
        return binarySearch(values,0,values.length-1,key);
    }
    public static<T> int binarySearch(Comparable<T>[] values,int begin,int end,T key) {
        if (key != null) {
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (values[mid].compareTo(key) == 0) {
                    return mid;
                }
                if (values[mid].compareTo(key) < 0) {
                    begin = mid + 1;
                }
                if (values[mid].compareTo(key) > 0) {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arrays, int key) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        int start=0,end=arrays.length-1;
        while (start <=end) {
            int mid = (start + end) / 2;
            if (arrays[mid] == key) {
                return mid;
            }
            if (arrays[mid] < key) {
                start = mid + 1;
            }
            if (arrays[mid] > key) {
                end = mid - 1;
            }

        }
        return -1;
    }
}
