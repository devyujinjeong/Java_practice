package com.dbwls.comprehensive.ui;

import com.dbwls.comprehensive.Service.AccountService;
import com.dbwls.comprehensive.Service.CurrentAccountService;
import com.dbwls.comprehensive.domain.Account;
import com.dbwls.comprehensive.persistence.AccountRepository;
import com.dbwls.comprehensive.persistence.FileAccountStorage;
import com.dbwls.comprehensive.userException.NotEnoughtMoneyException;

import java.util.List;
import java.util.Scanner;

/* 실행 및 UI*/
public class Application {
    private final AccountService accountService;
    private final CurrentAccountService currentAccountService;
    private final Scanner sc;

    public Application() {
        AccountRepository accountRepository = new AccountRepository(new FileAccountStorage());
        this.accountService = new AccountService(accountRepository);
        this.currentAccountService = new CurrentAccountService(accountRepository);
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===== 은행 프로그램 =====");
            System.out.println("1. 모든 계좌 조회");
            System.out.println("2. 특정 회원의 계좌 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 송금");
            System.out.println("6. 계좌 등록하기");
            System.out.println("7. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> showAllAccounts();
                    case 2 -> showAccountByName();
                    case 3 -> deposit();
                    case 4 -> withdraw();
                    case 5 -> transfer();
                    case 6 -> registerAccount();
                    case 7 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }

    // 모든 계좌 조회하기
    public void showAllAccounts(){
        List<Account> accounts = accountService.findAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("조회할 계좌가 없습니다.");
        } else {
            accounts.forEach(System.out::println);
        }
    }

    // 특정 회원의 계좌 조회하기
    public void showAccountByName(){
        System.out.print("조회할 회원 이름을 입력하세요: ");
        String name = sc.nextLine();
        List<Account> accounts = accountService.finAccountByUserName(name);
        if (accounts.isEmpty()) {
            System.out.println("해당 회원의 계좌가 없습니다.");
        } else {
            accounts.forEach(System.out::println);
        }
    }

    // 계좌 등록하기
    public void registerAccount(){
        try{
            System.out.print("이름을 입력하세요: ");
            String name = sc.nextLine();

            System.out.print("계좌 번호를 입력하세요: ");
            String accountNumber = sc.nextLine();

            System.out.print("비밀 번호를 입력하세요: ");
            String pwd = sc.nextLine();

            Account account = new Account(name, pwd, accountNumber);
            accountService.registerAccount(account);
            System.out.println("계좌가 성공적으로 등록되었습니다.");
        }catch (IllegalArgumentException e) {
            System.out.println("계좌 등록 실패: " + e.getMessage());
        }

    }

    // 입금하기
    public void deposit(){
        System.out.print("입금할 계좌 번호를 입력하세요: ");
        String accountNumber = sc.nextLine();
        System.out.print("입금할 금액을 입력하세요: ");
        int money = sc.nextInt();
        sc.nextLine();

        currentAccountService.deposit(accountNumber, money);
        System.out.println(money + "원이 입금되었습니다.");
    }

    // 출금하기
    public void withdraw(){
        System.out.print("출금할 계좌 번호를 입력하세요: ");
        String accountNumber = sc.nextLine();
        System.out.print("출금할 금액을 입력하세요: ");
        int money = sc.nextInt();
        sc.nextLine();

        try {
            currentAccountService.withdraw(accountNumber, money);
            System.out.println(money + "원이 출금되었습니다.");
        } catch (NotEnoughtMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    // 송금하기
    public void transfer(){
        System.out.print("송금할 계좌 번호를 입력하세요: ");
        String fromAccountNumber = sc.nextLine();
        System.out.print("받을 계좌 번호를 입력하세요: ");
        String toAccountNumber = sc.nextLine();
        System.out.print("송금할 금액을 입력하세요: ");
        int money = sc.nextInt();
        sc.nextLine();

        try {
            currentAccountService.transfer(fromAccountNumber, toAccountNumber, money);
            System.out.println(money + "원이 송금되었습니다.");
        } catch (NotEnoughtMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
