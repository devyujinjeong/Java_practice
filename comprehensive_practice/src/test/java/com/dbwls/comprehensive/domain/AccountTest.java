package com.dbwls.comprehensive.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("정유진", "1234", "010-12341234-567");
    }

    @Test
    void getName() {
        assertEquals("정유진", account.getName());
    }

    @Test
    void getPwd() {
        assertEquals("1234", account.getPwd());
    }

    @Test
    void getAccountNumber() {
        assertEquals("010-12341234-567", account.getAccountNumber());
    }

    @Test
    void getMoney() {
        assertEquals(0, account.getMoney());  // 기본값 0인지 확인 (Account 클래스의 초기값에 따라 다름)
    }

    @Test
    void setMoney() {
        account.setMoney(10000);
        assertEquals(10000, account.getMoney());
    }
}
