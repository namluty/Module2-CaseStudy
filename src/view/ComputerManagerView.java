package view;

import controller.ComputerManager;
import model.Computer;
import model.Service;
import storage.DataManager;

import java.util.List;
import java.util.Scanner;

public class ComputerManagerView {
    static DataManager<Computer> dataManager = new DataManager();
    static List<Computer> computerList = dataManager.readFile("computerList.txt");
    public static ComputerManager computerManager = new ComputerManager(computerList, "admin");

    public static void addComputer() {
        Computer newComputer = ComputerView.createNewComputer();
        computerManager.addComputer(newComputer);
    }
    public static void editComputer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter iD name of Computer you need edit: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            Computer newComputer = ComputerView.createNewComputer();
            computerManager.editComputer(index,newComputer);
            System.out.println("Finish");
        }
    }
    public static void searchComputer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID you are want to Search: ");
        String id = scanner.nextLine();
        int index = computerManager.searchById(id);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println(computerManager.getComputerList().get(index));
        }
    }
    public static void addTimePlay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID name of Computer you need add time play: ");
        String id = scanner.nextLine();
        int index = computerManager.searchById(id);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println("Enter a time play: ");
            int timePlay = scanner.nextInt();
            computerManager.addTimePlay(index,timePlay);
            System.out.println("Add finish");
        }
    }
    public static void checkStatus() {
        System.out.println(computerManager.checkStatus());
    }
    //check tng computer
    public static void checkStatusByIndex() {
        System.out.println(computerManager.checkStatus());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter iD name of Computer you need search: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println(computerManager.checkStatusByIndex(index));
        }
    }
    public static void payMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter iD name of Computer you need pay: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println(computerManager.payMoney(index));
        }
    }
    public static void addService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter iD name of Computer you need add Service: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        }else {
            Service services = ServiceView.creatService();
            computerManager.addService(index,services);
        }
    }
    public static void showAll() {
        computerManager.showAll();
    }
}
