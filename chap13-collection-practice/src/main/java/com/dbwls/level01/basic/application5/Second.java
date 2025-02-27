package com.dbwls.level01.basic.application5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Second {
    public static void main(String[] args) {
        // 실습 5 : 사전 순 단어 정렬
        // 중복을 허용하는 경우 : ArrayList에 저장한 뒤에 정렬해서 출력
        Scanner sc = new Scanner(System.in);

        ArrayList<String> word2 = new ArrayList<>();

        while(true){
            System.out.print("단어 입력 ('exit' 입력 시 종료) : ");
            String s = sc.nextLine();

            if(s.equals("exit")){
                Collections.sort(word2);
                System.out.println("정렬 된 단어 : " + word2);
                break;
            }else{
                word2.add(s);
            }
        }
    }
}
