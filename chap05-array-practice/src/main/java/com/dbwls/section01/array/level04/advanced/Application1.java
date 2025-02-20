package com.dbwls.section01.array.level04.advanced;

import java.util.Arrays;
import java.util.HashSet;

public class Application1 {

    public static void main(String[] args) {

        /* 로또번호 생성기
         * 6칸 짜리 정수 배열을 하나 생성하고
         * 1부터 45까지의 중복되지 않는 난수를 발생시켜 각 인덱스에 대입한 뒤
         * 오름차순 정렬하여 출력하세요.
         * Arrays.sort(배열) 메소드 활용하여 정렬 가능.
         * */

        // 중복을 제거하기 위해 사용
        HashSet<Integer> hs = new HashSet<>();
        int[] lotto = new int[6];

        while(hs.size()!=6){
            int n = (int)(Math.random()*46)+1;
            hs.add(n);
        }

        int i=0;
        for(int num : hs){
            lotto[i++] = num;
        }

        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));

    }

}