package com.dbwls.practice03;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("철수", "수학", 95),
                new Student("철수", "영어", 80),
                new Student("영희", "수학", 90),
                new Student("영희", "영어", 91),
                new Student("민수", "수학", 85),
                new Student("민수", "영어", 88)
        );

        // 1. 각 학생의 평균 점수를 계산하여 맵으로 반환
        Map<String, Double> averageScoreByStudent = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.averagingDouble(Student::getScore)
                ));

        System.out.println(averageScoreByStudent);

        // 2. 특정 과목(수학)에서 90점 이상 받은 학생의 이름을 리스트로 반환
        List<String> highScorersInMath = students.stream()
                .filter(student -> "수학".equals(student.getSubject()))
                .filter(student -> student.getScore()>=90)
                .map(Student::getName)
                .toList();

        System.out.println(highScorersInMath);

        // 3. 가장 높은 평균 점수를 가진 학생의 이름을 반환
        String topStudent = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.averagingInt(Student::getScore) // 학생별 평균 점수 계산
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // 가장 높은 평균 점수를 가진 학생 찾기
                .map(Map.Entry::getKey) // 학생 이름 반환
                .orElseThrow(); // 값이 없으면 예외 발생

        System.out.println(topStudent);
    }
}