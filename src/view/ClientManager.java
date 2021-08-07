package view;

import controller.ComputerManager;
import model.Computer;
import storage.DataManager;

import java.util.List;
import java.util.Scanner;

public class ClientManager {
    static AccountView accountView = new AccountView();
    static DataManager<Computer> dataManager = new DataManager();
    static List<Computer> computerList = dataManager.readFile("computerList.txt");
    public static ComputerManager computerManager = new ComputerManager(computerList, "admin");
    static ComputerManagerView computerManagerView = new ComputerManagerView();

    public static void main(String[] args) {
//        login();
        System.out.println("Next Step!!!");

        Scanner input = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Creat a computer in Room Gamming: ");
            System.out.println("2. Display list computer in Room Gamming: ");
            System.out.println("3. Edit a computer in Room Gamming: ");
            System.out.println("4. Delete a computer in Room Gamming: ");
            System.out.println("5. Add Service Other: "); //Thêm dịch vụ
            System.out.println("6. Edit hour billing: "); //Chỉnh sửa tính tiền theo giờ
            System.out.println("7. Bill please: "); //Tính tiền
            System.out.println("8. Manager Login Account: ");
            System.out.println("9. Show Turnover: "); //Hiển thị Doanh thu
            System.out.println("0. Exit!!!: ");
            System.out.println("Enter your choose: ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    computerManagerView.addComputer(computerManager);
                    break;
                case 2:
                    Scanner scannerss = new Scanner(System.in);
                    System.out.println("Enter a: to Show All Computer: ");
                    System.out.println("Enter b: to Show Detail One Computer: ");
                    String type = scannerss.nextLine();
                    switch (type) {
                        case "a": {
                            computerManagerView.showAll(computerManager);
                            break;
                        }
                        case "b": {
                            computerManagerView.checkStatusByIndex(computerManager);
                        }
                            break;
                    }
                    break;
                case 3:
                    computerManagerView.editComputer(computerManager);
                    break;
                case 4:
                    computerManagerView.deleteComputer(computerManager);
                    break;
                case 5:
                    computerManagerView.addService(computerManager);
                    break;
                case 6:
                    computerManagerView.addTimePlay(computerManager);
                    break;
                case 7:
                    computerManagerView.payMoneys(computerManager);
                    break;
                case 8:

                    break;
                case 9:
                    computerManagerView.showTotalMoney(computerManager);
                    break;
                case 0:
                    System.out.println("Exit Menu!!!");
                default:
                    System.out.println("Thank you so much. See You Again!!!");
            }
        }
    }


    static void login() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("---WELCOME TO MIXI GAMMING---");
        System.out.println("User Name: ");
        String username = scan1.nextLine();

        System.out.println("Passwords: ");
        String password = scan1.nextLine();

        if (username.equalsIgnoreCase("namluty") && password.equals("nam123")) {
            System.out.println("Login Success!!!");
        } else {
            System.err.println("Login Failed - Please Re-Login");
            login();
        }
    }
}
