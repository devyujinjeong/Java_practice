package com.dbwls.level01.basic;

// 1. 제네릭 메소드를 설정해서 사용하는 경우
public class Application2_1 {
    // 1. 연산을 double 타입으로 돌려주기
    // 2. 만약 그 때마다 원하는 자료형으로 값을 리턴하고 싶다면? 리턴에 T를 쓴 뒤에
    // : 자료형을 검사해서 해당하는 자료형으로 리턴되게 만들어줘야 함.

    // Number또는 그 하위 타입만 작성을 허용함
    static <T extends Number> double sum(T[] arr) {
        double total = 0.0;

        for (T numData : arr) {
            total += numData.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        // 더블로 리턴된 값을 int형으로 바꿔줌
        System.out.println("Integer 합계 : " + (int)sum(intArray));

        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Double 합계 : " + sum(doubleArray));

        String[] strArray = {"A", "B", "C"};
//         System.out.println("String 합계 : " + sum(strArray));  // 컴파일 에러 발생
    }
}