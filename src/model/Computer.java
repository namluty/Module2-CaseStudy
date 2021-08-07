package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Serializable {
    private String idName;
    private String status;
    private int timePlay;
    public static final double UNIT_PRICE = 50000;
    public static final String ONLINE = "Avaiable";
    public static final String OFFLINE = "Disable";
    List<Service> serviceList = new ArrayList<>();

    public Computer() {
    }

    public Computer(String idName) {
        this.idName = idName;
        this.status = OFFLINE;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimePlay() {
        return timePlay;
    }

    public void setTimePlay(int timePlay) {
        this.timePlay = timePlay;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "idName='" + idName + '\'' +
                ", status='" + status + '\'' +
                ", timePlay=" + timePlay +
                ", serviceList=" + serviceList +
                '}';
    }
    public double payService() {
        double sum = 0;
        for (Service service:serviceList) {
            sum += service.getPrice();
        }
        return sum;
    }

    public double calculatorMoney() {
        return payService() + timePlay * UNIT_PRICE;
    }
}
