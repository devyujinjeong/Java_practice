package com.dbwls.level01.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        // 실습 1. 점수의 평균 구하기
        // 컬렉션을 사용하지 않고, sum과 count를 통해 점수 합계와 학생 수를 구해서 평균을 구해도 됨

        // 사용하려는 Collection : ArrayList
        // 점수가 언제까지 증가될 지 모르니 ArrayList를 사용해 값을 추가

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        // 점수의 총합을 계산하기 위함
        int sum = 0;

        while(true){
            // 1. 학생의 성적 입력 받기
            System.out.print("학생 성적 : ");
            int score = sc.nextInt();

            // 2. 학생의 성적 ArrayList에 추가하기
            scores.add(score);

            System.out.print("추가 입력하려면 y : ");
            char c = sc.next().charAt(0);
            // 3. 만약 입력  값이 'y'나 'Y'가 아니라면 멈추기
            if(!(c=='y'|| c=='Y')){
                break;
            }
        }

        for(int score : scores){
            sum+=score;
        }

        System.out.println("평균 점수 : "+ (double)sum/scores.size());
    }
}
