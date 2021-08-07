package view;

import controller.ComputerManager;
import model.Computer;
import model.Service;

import java.util.Scanner;

public class ComputerManagerView {

    public static void addComputer(ComputerManager computerManager) {
        Computer newComputer = ComputerView.createNewComputer();
        computerManager.addComputer(newComputer);
    }
    public static void editComputer(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to Edit: ");
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
//    public void editComputer(ComputerManager computerManager) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your input a name want to Edit: ");
//        String search = scanner.nextLine();
//        Computer name = computerManager.findByName(search);
//        if (name == null)
//            System.out.println("Not Found!");
//        else {
//            Scanner scanner1 = new Scanner(System.in);
//            System.out.println("Enter replace the old name: " + name.getIdName());
//            String newName = scanner1.nextLine();
//            name.setIdName(newName);
//        }
//    }
//    public void deleteComputer(ComputerManager computerManager) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your input a name want to Delete: ");
//        String name = scanner.nextLine();
//        Computer names = computerManager.findByName(name);
//        if (names == null)
//            System.out.println("Name does not exist");
//        else {
//            computerManager.deleteComputer(names);
//        }
//    }
    public static void deleteComputer(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to Delete: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            Computer newComputer = ComputerView.createNewComputer();
            computerManager.deleteComputer(index);
            System.out.println("Finish");
        }
    }
//    public static void searchComputer(ComputerManager computerManager) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter ID you are want to Search: ");
//        String id = scanner.nextLine();
//        int index = computerManager.searchByName(id);
//        if (index == -1) {
//            System.out.println("Not Found Computer");
//        } else {
//            System.out.println(computerManager.getComputerList().get(index));
//        }
//    }
    public static void addTimePlay(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to add time play: ");
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
    public static void checkStatus(ComputerManager computerManager) {
        System.out.println(computerManager.checkStatus());
    }
    //check tng computer
    public static void checkStatusByIndex(ComputerManager computerManager) {
        System.out.println(computerManager.checkStatus());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to Search: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println(computerManager.checkStatusByIndex(index));
        }
    }
    public static void payMoneys(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to Pay: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        } else {
            System.out.println(computerManager.payMoney(index));
        }
    }
    public static void addService(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter idName of Computer your want to add Service: ");
        String idName = scanner.nextLine();
        int index = computerManager.searchById(idName);
        if (index == -1) {
            System.out.println("Not Found Computer");
        }else {
            Service services = ServiceView.creatService();
            computerManager.addService(index,services);
        }
    }
    public static void showAll(ComputerManager computerManager) {
        computerManager.showAll();
    }
}
