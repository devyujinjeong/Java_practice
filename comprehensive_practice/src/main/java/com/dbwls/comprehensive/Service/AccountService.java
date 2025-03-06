package com.dbwls.comprehensive.Service;

import com.dbwls.comprehensive.domain.Account;
import com.dbwls.comprehensive.persistence.AccountRepository;

import java.util.List;
import java.util.regex.Pattern;

/* 계좌 등록 */
public class AccountService {
    private final AccountRepository accountRepository;
    private static final Pattern ACCOUNT_NUMBER_PATTERN = Pattern.compile("^[0-9]{3}-[0-9]{8}-[0-9]{3}$");
    private static final int PASSWORD_LENGTH = 4 ;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllAccounts(){
        return accountRepository.selectAllAccount();
    }

    public List<Account> finAccountByUserName(String name){
        return accountRepository.selectAccountByName(name);
    }

    public void registerAccount(Account account) {
        String accountNumber = account.getAccountNumber();
        // 계좌 등록 로직
        if (isEqualAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("계좌 개설 실패 : 이미 존재하는 계좌입니다.");
        }

        if (!isValidAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("계좌 개설 실패 : 계좌의 형식에 맞게 작성해주세요.");
        }

        if (!isValidPassword(account.getPwd())) {
            throw new IllegalArgumentException("계좌 개설 실패 : 비밀번호는 4자리로 입력해주세요.");
        }

        accountRepository.insertAccount(account);
    }

    // 계좌 번호 존재 여부 확인
    private boolean isEqualAccountNumber(String accountNumber) {
        return accountRepository.selectAllAccount()
                .stream()
                .anyMatch(account -> account.getAccountNumber().equals(accountNumber));
    }

    // 계좌 번호 형식 확인
    private boolean isValidAccountNumber(String accountNumber) {
        return ACCOUNT_NUMBER_PATTERN.matcher(accountNumber).matches();
    }

    // 비밀번호 유효성 검사
    private boolean isValidPassword(String password) {
        return password.length() == PASSWORD_LENGTH;
    }
}

