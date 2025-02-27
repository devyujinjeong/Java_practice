package com.dbwls.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        // 실습 3 : 대기 줄 시뮬레이션
        // 먼저 들어온 고객이 먼저 나가기 때문에, queue 자료 구조를 통해 작성하기

        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();

        while(true){
            System.out.print("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
            String s = sc.nextLine();
            if(s.equals("next")){
                // 대기 고객이 없는 경우
                if(q.isEmpty()){
                    System.out.println("대기 고객이 없습니다.");
                }else{
                    System.out.println(q.poll() + " 고객님 차례입니다.");
                }
            }else if(s.equals("exit")){
                break;
            }else{
                q.add(s);
                System.out.println(s + " 고객님 대기 등록 되었습니다.");
            }
        }
    }
}
