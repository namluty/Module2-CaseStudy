package view;

import controller.AccountManager;
import model.Account;
import model.Computer;
import storage.DataManager;

import java.util.List;
import java.util.Scanner;

public class AccountView {

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
        Account newAcc = new Account(username, password, id);
        accountManager.addNewAccount(newAcc);
    }

    public static void showAllAccount(AccountManager accountManager) {
        System.out.println("List Account: ");
        for (Account account : accountManager.getAccountList()) {
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

    public static void editAccount(AccountManager accountManager) {
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

    public static void showMenuAccount(AccountManager accountManager) {
        Scanner input1 = new Scanner(System.in);
        int choose = -1;

        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Creat a account: ");
            System.out.println("2. Display list account: ");
            System.out.println("3. Edit a account: ");
            System.out.println("4. Delete a account: ");
            System.out.println("0. Exit!!!: ");
            System.out.println("Enter your choose: ");
            choose = input1.nextInt();
            switch (choose) {
                case 1:
                    createNewAccount(accountManager);
                    break;
                case 2:
                    showAllAccount(accountManager);
                    break;
                case 3:
                    AccountView.editAccount(accountManager);
                    break;
                case 4:
                    AccountView.deleteAcccount(accountManager);
                    break;
                case 0:
                    System.out.println("Exit Menu!!!");
                default:
                    System.out.println("See You Again");
            }
        }
    }
}