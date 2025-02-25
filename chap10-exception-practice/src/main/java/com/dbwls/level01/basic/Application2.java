package com.dbwls.level01.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
        String input = sc.nextLine();

        try {
            checkDate(input);
            checkAge(input);
            System.out.println("입장하셔도 됩니다.");
        }catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }catch (ParseException e){
            System.out.println("날짜 양식을 잘못 입력하셨습니다.");
        }
    }

    public static void checkAge(String birth) throws InvalidAgeException{
        // 현재 날짜 구하기
        LocalDate dateNow = LocalDate.now();
        // year, month, day를 각각 분리해서, 계산 진행하기
        String[] s = birth.split("-");

        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int dayOfMonth = Integer.parseInt(s[2]);

        int diffYear = dateNow.getYear() - year;
        int diffMonth = dateNow.getMonthValue() - month;
        int diffDayOfMonth = dateNow.getDayOfMonth() - dayOfMonth;

        if (diffMonth < 0 || (diffMonth == 0 && diffDayOfMonth < 0)) {
            diffYear--;
        }

        if (diffYear < 20) {
            throw new InvalidAgeException("만 20세 미만은 입장 불가입니다.");
        }
    }

    public static void checkDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        sdf.parse(date);

    }

}