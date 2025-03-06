package com.dbwls.comprehensive.persistence;

import com.dbwls.comprehensive.domain.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccountStorage implements AccountStorage{
    private static final String FILE_PATH = "src/main/java/com/dbwls/comprehensive/db/AccountDB.dat";

    @Override
    public void saveAccounts(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생", e);
        }
    }

    @Override
    public List<Account> loadAccounts() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Account>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("계좌 정보를 모두 로딩하였습니다.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("파일 로딩 중 오류 발생", e);
        }
    }
}
