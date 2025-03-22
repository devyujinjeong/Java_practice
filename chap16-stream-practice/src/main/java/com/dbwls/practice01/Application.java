package com.dbwls.practice01;

import java.util.*;
import java.util.stream.Collectors;

public class Application{

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("홍길동", 25, "IT", 6000),
                new Employee("김철수", 28, "HR", 3000),
                new Employee("이영희", 30, "IT", 7000),
                new Employee("박민수", 22, "영업", 4000),
                new Employee("최지현", 35, "HR", 3500),
                new Employee("한석봉", 40, "IT", 5000)
        );

        // 1. 모든 직원의 이름을 쉼표로 구분된 문자열로 반환
        Object List;
        String allNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println(allNames);

        // 2. IT 부서에서 급여가 5,000 이상인 직원의 이름을 급여 순으로 내림차순 정렬하여 반환
        // 스트림화 -> IT 부서만 가져오기 -> 이름을 가져오기 -> 급여가 5000만원 이상
        List<String> highSalaryIT = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .filter(e -> e.getSalary() >= 5000)
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .map(Employee::getName)
                .toList();

        System.out.println(highSalaryIT);

        // 3. 각 부서별 평균 급여를 계산하여 맵으로 반환
        Map<String, Double> averageSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println(averageSalaryByDept);
    }
}
