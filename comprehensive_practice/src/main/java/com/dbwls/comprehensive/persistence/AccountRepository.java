package com.dbwls.comprehensive.persistence;

import com.dbwls.comprehensive.domain.Account;

import java.util.ArrayList;
import java.util.List;

/* Account 데이터 저장 및 조회*/
// 현재는 값이 DB에 저장되어 있지 않기 때문에 이런 방식으로 구현
public class AccountRepository {
    private final AccountStorage accountStorage;
    private final List<Account> accountList;

    public AccountRepository(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
        this.accountList = accountStorage.loadAccounts();
    }

    // 모든 계좌 가져오기
    public List<Account> selectAllAccount() {
        return new ArrayList<>(accountList);
    }


    // 고객의 이름으로 계좌 찾기
    public List<Account> selectAccountByName(String name) {
        return accountList.stream().filter(account -> account.getName().equals(name)).toList();
    }

    // 계좌 개설하기
    public void insertAccount(Account account) {
        accountList.add(account);
        accountStorage.saveAccounts(accountList);
    }

    // 계좌 수정하기
    public void updateAccount(Account updatedaccount) {
        for (int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getAccountNumber().equals(updatedaccount.getAccountNumber())){
                accountList.set(i,updatedaccount);
                accountStorage.saveAccounts(accountList);
                break;
            }
        }
    }
}
