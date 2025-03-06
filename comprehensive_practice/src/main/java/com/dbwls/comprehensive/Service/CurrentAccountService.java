package com.dbwls.comprehensive.Service;

import com.dbwls.comprehensive.domain.Account;
import com.dbwls.comprehensive.persistence.AccountRepository;
import com.dbwls.comprehensive.userException.NotEnoughtMoneyException;

/* 입/출금 계좌 */
public class CurrentAccountService {
    private final AccountRepository accountRepository;
    private static final int MAX_MONEY = 1000000;

    public CurrentAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // 입금하기
    public void deposit(String accountNumber, int money) {
        Account account = findAccountByAccountNumber(accountNumber);
        account.setMoney(account.getMoney() + money);
        accountRepository.updateAccount(account);
    }

    // 출금하기
    public void withdraw(String accountNumber, int money) throws NotEnoughtMoneyException {
        Account account = findAccountByAccountNumber(accountNumber);

        if(!checkMaxMoney(money)){
            throw new IllegalArgumentException("한 번에 출금 가능한 최대 금액은 " + MAX_MONEY +"원 입니다.");
        }

        if (account.getMoney() < money) {
            throw new NotEnoughtMoneyException("잔액이 부족합니다.");
        }

        account.setMoney(account.getMoney() - money);
        accountRepository.updateAccount(account);
    }

    // 계좌이체
    public void transfer(String fromAccountNumber, String toAccountNumber, int money) throws NotEnoughtMoneyException {
        if (fromAccountNumber.equals(toAccountNumber)) {
            throw new IllegalArgumentException("송금 실패 : 출금 계좌와 입금 계좌는 동일할 수 없습니다.");
        }

        Account fromAccount = findAccountByAccountNumber(fromAccountNumber);
        Account toAccount = findAccountByAccountNumber(toAccountNumber);

        if (fromAccount.getMoney() < money) {
            throw new NotEnoughtMoneyException("잔액이 부족합니다.");
        }

        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
    }

    // 출금 최대 금액 확인
    private boolean checkMaxMoney(int money){
        return money <= MAX_MONEY;
    }

    // 계좌가 존재하는지 확인하기
    private Account findAccountByAccountNumber(String accountNumber) {
        return accountRepository.selectAllAccount()
                .stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("계좌가 존재하지 않습니다."));
    }
}
