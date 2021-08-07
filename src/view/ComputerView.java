package view;

import model.Computer;

import java.util.Scanner;

public class ComputerView {
    public static Computer createNewComputer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name Computer: ");
        String name = scanner.nextLine();
        return new Computer(name);
    }
}
