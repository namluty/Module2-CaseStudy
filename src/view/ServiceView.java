package view;

import model.Service;

import java.util.Scanner;

public class ServiceView {
    public static Service creatService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name service: ");
        String name = scanner.nextLine();
        System.out.println("Enter a price service: ");
        int price = scanner.nextInt();
        return new Service(name, price);
    }
}
