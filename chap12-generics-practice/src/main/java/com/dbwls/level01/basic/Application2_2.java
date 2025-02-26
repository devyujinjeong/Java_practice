package com.dbwls.level01.basic;

import java.util.List;

// 2. 와일드 카드를 사용하고 싶은 경우
public class Application2_2 {
    static double sum(List<? extends Number> arr) {
        double total = 0.0;

        for (Number numData : arr) {
            total += numData.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        // 배열을 List 형태로 변환시켜줘야 sum 메소드 사용이 가능하다.
        // 그래서 List.of라는 것을 이용해 배열을 List로 변환 시켜줬다.
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Integer 합계 : " + (int)sum(List.of(intArray)));

        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Double 합계 : " + sum(List.of(doubleArray)));

        String[] strArray = {"A", "B", "C"};
//         System.out.println("String 합계 : " + sum(strArray));  // 컴파일 에러 발생
    }
}
