package com.dbwls.comprehensive.domain;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private String name; // 회원 이름
    private String pwd; // 계좌 비밀번호
    private final String accountNumber; // 계좌 번호
    private int money; // 계좌에 들어 있는 금액

    public Account(String name, String pwd, String accountNumber) {
        this.name = name;
        this.pwd = pwd;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }
}
