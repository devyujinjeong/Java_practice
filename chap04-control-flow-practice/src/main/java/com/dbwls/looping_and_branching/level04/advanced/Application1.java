package com.dbwls.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서
         * 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
         *
         * A를 3만큼 밀면 D가 되고, z를 1만큼 밀면 a가 됩니다.
         * 또한 공백문자는 변경되지 않습니다.
         *
         * 문자열 1개를 입력 받고, 얼마나 문자를 밀지 알려주는 0보다 큰 정수를 1개 입력 받아
         * 암호문을 작성하는 프로그램을 만들어보세요
         * 단, 숫자가 27인 경우는 1칸을 밀게 됩니다. (알파벳은 26글자 이기 때문)
         *
         * -- 입력 예시 --
         * 문자열을 입력하세요 : a B z
         * 숫자를 입력하세요 : 4
         *
         * -- 출력 예시 --
         * e F d
         *
         * -- 입력 예시 --
         * 문자열을 입력하세요 : a B z
         * 숫자를 입력하세요 : 27
         *
         * -- 출력 예시 --
         * b C a
         * */

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String s = sc.nextLine();
        System.out.print("숫자를 입력하세요 : ");
        int n = sc.nextInt();
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') { // 대문자인 경우
                answer += (char) ((ch - 'A' + n) % 26 + 'A');
            } else if (ch >= 'a' && ch <= 'z') { // 소문자인 경우
                answer += (char) ((ch - 'a' + n) % 26 + 'a');
            } else { // 공백인 경우
                answer += ch;
            }
        }

        System.out.println(answer);
    }
}
