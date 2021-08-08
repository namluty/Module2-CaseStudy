package controller;

import model.Account;
import storage.DataManager;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private DataManager<Account> dataManager = new DataManager<>();
    private String name;
    private List<Account> accountList= new ArrayList<>();

    public AccountManager() {
    }

    public AccountManager(String name, List<Account> accountList) {
        this.name = name;
        this.accountList = accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addNewAccount(Account account) {
        accountList.add(account);
        dataManager.writeFile(accountList, "accountList.txt");
    }
    public Account findById(int id) {
        Account account = null;
        for (Account acc : accountList
        ) {
            if (acc.getId()==(id))
                account = acc;
        }
        return account;
    }


    public Account findByNameAcc(String name) {
        Account account = null;
        for (Account acc : accountList
        ) {
            if (acc.getUsername().equals(name))
                account = acc;
        }
        return account;
    }

    public void deleteAcccount(Account account) {
        accountList.remove(account);
        dataManager.writeFile(accountList, "accountList.txt");
    }

   }
