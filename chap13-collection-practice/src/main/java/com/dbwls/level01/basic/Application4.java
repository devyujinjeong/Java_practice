package com.dbwls.level01.basic;

import java.util.HashSet;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        // 실습 4 : 학생 ID 관리
        // 사실 아이디의 중복을 허용하지 않아서 아이디가 있는지 여부를 검사해야 한다.
        // 그래서 굳이 hashSet을 이용하지 않고 ArrayList를 이용해서 구현할 수 있지만,
        // contains라는 메소드의 경우 hashSet을 이용하는 것이 더 효율적이므로 hashSet을 사용한다.
        // 그리고 이 문제에서는 순서가 없으므로, hashSet 구조를 사용했다.
        HashSet<String> studentIds = new HashSet<>();
        Scanner sc  = new Scanner(System.in);

        while(true){
            System.out.print("학생 ID 입력('exit' 입력 시 종료) : ");
            String s = sc.nextLine();

            if(s.equals("exit")){
                System.out.println("모든 학생의 ID : " + studentIds);
                break;
            }else{
                if(studentIds.contains(s)){
                    System.out.println("이미 등록 된 ID 입니다.");
                }else{
                    studentIds.add(s);
                    System.out.println("ID가 추가되었습니다.");
                }
            }

        }
    }
}
