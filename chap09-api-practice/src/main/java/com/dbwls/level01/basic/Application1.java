package com.dbwls.level01.basic;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        System.out.print("문자열 입력 : ");
        String s = sc.nextLine();
        String[] sArr = s.split(" ");
        // 모든 단어를 소문자로 변환하기
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 만약에 공백이라면 공백 추가
            if (c == ' ') {
                sb.append(' ');
            }
            // 첫 글자이거나 그 전이 공백이면 대문자로 변환
            else if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(c));  // 대문자로 변환하여 추가
            }
            // 나머지 문자는 그대로 소문자로
            else {
                sb.append(c);
            }
        }

        System.out.println("변환된 문자열 : " + sb.toString());
        System.out.println("총 단어 개수 : " + sArr.length);
    }
}