package com.dbwls.level01.basic.student.run;

import com.dbwls.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static int getAvg(int kor, int eng, int math){
        return (int)(kor+eng+math)/3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 10명의 학생 정보를 기록할 배열
        StudentDTO[] students = new StudentDTO[10];

        // 학생의 수를 세는 변수
        int count = 0;
        while(count<10){
            System.out.print("학년 : ");
            int grade = sc.nextInt();

            System.out.print("반 : ");
            int classroom = sc.nextInt();

            System.out.print("이름 : ");
            String name = sc.next();

            System.out.print("국어점수 : ");
            int kor = sc.nextInt();

            System.out.print("영어점수 : ");
            int math = sc.nextInt();

            System.out.print("수학점수 : ");
            int eng = sc.nextInt();

            students[count++] = new StudentDTO(grade, classroom, name, kor, math, eng);

            System.out.print("계속 추가할 겁니까 ? (y/n) : ");
            char c = sc.next().charAt(0);
            if(c=='n'){
                break;
            }
        }

        for(int i=0; i<count ;i++){
            System.out.println(students[i].getInformation() + ", " + getAvg(students[i].getKor(), students[i].getEng(), students[i].getMath()));
        }
    }
}
