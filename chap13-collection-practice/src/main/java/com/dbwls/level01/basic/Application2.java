package com.dbwls.level01.basic;

import java.util.Scanner;
import java.util.Stack;

public class Application2 {
    public static void main(String[] args) {
        // 실습 2 : 방문 url
        // stack을 이용해서 문제 해결
        Scanner sc = new Scanner(System.in);
        Stack<String> urlStack = new Stack<>();

        while (true) {
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            String url = sc.nextLine();

            if (url.equals("exit")) {
                break;
            }

            urlStack.push(url);

            System.out.print("최근 방문 url : ");
            for (int i = urlStack.size() - 1; i >= 0; i--) {
                System.out.print(urlStack.get(i) + " ");
            }
            System.out.println();
        }
    }
}
