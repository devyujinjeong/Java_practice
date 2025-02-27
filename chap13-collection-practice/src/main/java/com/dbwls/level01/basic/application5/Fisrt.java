package com.dbwls.level01.basic.application5;

import java.util.Scanner;
import java.util.TreeSet;

public class Fisrt {
    public static void main(String[] args) {
        // 실습 5 : 사전 순 단어 정렬
        // 중복을 허용하지 않는 경우 : 정렬이 되고 중복을 허용하지 않는 treeSet 이용

        Scanner sc = new Scanner(System.in);
        TreeSet<String> word1 = new TreeSet<>();

        while(true){
            System.out.print("단어 입력 ('exit' 입력 시 종료) : ");
            String s = sc.nextLine();

            if(s.equals("exit")){
                System.out.println("정렬 된 단어 : " + word1);
                break;
            }else{
                word1.add(s);
            }
        }
    }
}
