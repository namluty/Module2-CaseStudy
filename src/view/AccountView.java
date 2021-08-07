package view;

import controller.AccountManager;
import model.Account;
import storage.DataManager;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    static DataManager<Account> dataManager = new DataManager();
    private static List<Account> accountList = dataManager.readFile("accountList.txt");
    public static void createNewAccount(AccountManager accountManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user name: ");
        String username = scanner.nextLine();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String password = sc.nextLine();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your input a id account: ");
        int id = scan.nextInt();
        Account account = new Account(username, password, id);
        accountManager.addNewAccount(account);
    }
    public static void showAllAccount(AccountManager accountManager) {
        System.out.println("List Account: ");
        for (Account account:accountList) {
            System.out.println(account);
        }
    }


    public static void deleteAcccount(AccountManager accountManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input a ID want to Delete: ");
        int id = scanner.nextInt();
        Account ids = accountManager.findById(id);
        if (ids == null)
            System.out.println("ID does not exist");
        else {
            accountManager.deleteAcccount(ids);
        }
    }

    public void editAccount(AccountManager accountManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input a username want to Edit: ");
        String search = scanner.nextLine();
        Account name = accountManager.findByNameAcc(search);
        if (name == null)
            System.out.println("Not Found!");
        else {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter replace the old Account: " + name.getUsername());
            String newUsername = scanner1.nextLine();
            name.setUsername(newUsername);
        }
    }
}

