package com.dbwls.level01.basic;

import java.util.HashMap;
import java.util.Scanner;

public class Application6 {
    public static void main(String[] args) {
        // 실습 6 : 전화번후부
        // 이름을 key로 전화번호를 value로 해서 등록하기
        // 사실 이름은 겹칠 수 있지만 그냥 여기에서는 겹치지 않는다고 생각하기
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> hm = new HashMap<>();

        while(true){
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
            String s = sc.nextLine();
            String[] sarr = s.split(" ");

            // 끝내기를 원하는 경우 끝내기
            if(s.equals("exit")){
                break;
            // 전화번호 찾기
            }else if(s.equals("search")){
                // 번호가 있다면 출력
                System.out.print("검색 할 이름 : ");
                String finding = sc.nextLine();
                if(hm.containsKey(finding)){
                    System.out.println(finding+"씨의 전화번호 : " + hm.get(finding));
                // 번호가 없다면 등록되어 있지 않다고  하기
                }else{
                    System.out.println(finding+"씨의 번호는 등록 되어 있지 않습니다.");
                }
            }else{
                if(sarr.length==2){
                    hm.put(sarr[0],sarr[1]);
                    System.out.println("추가 완료 : " + sarr[0] +" "+ sarr[1]);
                }
            }
        }
    }
}
