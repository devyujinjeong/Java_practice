package com.greedy.level02.normal;

import java.util.Random;

public class RandomMarker {
    static int randomNumber(int max, int min){
        int num = (int)(Math.random()*(max-min+1))+min;
        return num;
    }

    static String randomUpperAlpabet(int length){
        String randomWord = "";
        // 형변환을 이용해 랜덤으로 알파벳 만들기
        for(int i=0; i<length; i++){
            int num = (int)(Math.random()*26)+65;
            char word = (char)num;
            randomWord+=word;
        }
        return randomWord;
    }

    static String rockScissorsPaper(){
        // 가위, 바위, 보에 각각 값을 넣고, 이 값을 랜덤으로 가져옴
        // 가위 = 0, 바위 = 1, 보 = 2로 생각
        int num = (int)(Math.random()*3);
        return num==0?"가위":num==1?"바위":"보";
    }

    static String tossCoin(){
        int num = (int)(Math.random()*2);
        return num==0?"앞면":"뒷면";
    }

}
