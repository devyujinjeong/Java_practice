package com.dbwls.level01.normal;

import java.util.Arrays;

public class Application1 {
    static <T> void swap(T[] arr, int a, int b){
        T temp = arr[a];
        // 위치 변경하기
        // 이 때, arr[a]를 변경하고 arr[b]에 넣어주면 원하는 값이 나오지 않으므로
        // arr[a]를 임시 변수에 저장하고 이를 넣어준다.
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("swap 전 : " + Arrays.toString(intArray));  // [1, 2, 3, 4, 5]
        swap(intArray, 1, 3);
        System.out.println("swap 후 : " + Arrays.toString(intArray));  // [1, 4, 3, 2, 5]

        String[] strArray = {"A", "B", "C", "D"};
        System.out.println("swap 전 : " + Arrays.toString(strArray));  // [A, B, C, D]
        swap(strArray, 0, 2);
        System.out.println("swap 후 : " + Arrays.toString(strArray));  // [C, B, A, D]
    }
}
