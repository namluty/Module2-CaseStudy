package controller;

import model.Computer;
import model.Service;
import storage.DataManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ComputerManager {
    private List<Computer> computerList = new ArrayList<>();
    private String name;
    private DataManager<Computer> dataManager = new DataManager<>();


    public ComputerManager() {
    }

    public ComputerManager(List<Computer> computerList, String name) {
        this.computerList = computerList;
        this.name = name;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addComputer(Computer computer) {
        computerList.add(computer);
        dataManager.writeFile(computerList, "computerList.txt");
    }

    public void editComputer(int index, Computer computer) {
        computerList.remove(index);
        computerList.add(computer);
        dataManager.writeFile(computerList, "computerList.txt");
    }

    public void deleteComputer(int index) {
        computerList.remove(index);
        dataManager.writeFile(computerList, "computerList.txt");
    }

    public int searchById(String id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getIdName().equals(id)) ;
            return i;
        }
        return -1;
    }

    public void addTimePlay(int index, int timePlay) {
        computerList.get(index).setTimePlay(timePlay);
        computerList.get(index).setStatus(Computer.ONLINE);
        dataManager.writeFile(computerList, "computerList.txt");
    }

    public void addService(int index, Service service) {
        if (computerList.get(index).getStatus().equals(Computer.ONLINE)) {
            computerList.get(index).getServiceList().add(service);
            dataManager.writeFile(computerList, "computerList.txt");
        }
    }

    public String checkStatus() {
        String result = "";
        for (Computer computer : computerList) {
            result += computer.getIdName() + "is: " + computer.getStatus() + "; \t";
        }
        return result;
    }

    public String checkStatusByIndex(int index) {
        return computerList.get(index).getIdName() + "is: " + computerList.get(index).getStatus();
    }

    public double payMoney(int index) {
        if (computerList.get(index).getStatus().equals(Computer.ONLINE)) {
            computerList.get(index).setServiceList(null);
            computerList.get(index).setStatus(Computer.OFFLINE);
            computerList.get(index).setTimePlay(0);
            dataManager.writeFile(computerList, "computerList.txt");
        }
        return computerList.get(index).calculatorMoney();
    }
    public void showAll() {
        for (Computer computer:computerList) {
            System.out.println(computer + ": " + computer.calculatorMoney());
        }
    }
}