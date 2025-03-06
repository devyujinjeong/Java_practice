package com.dbwls.comprehensive.persistence;

import com.dbwls.comprehensive.domain.Account;

import java.util.List;

public interface AccountStorage {
    void saveAccounts(List<Account> accounts);
    List<Account> loadAccounts();
}