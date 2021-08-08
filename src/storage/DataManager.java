package storage;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager<E> {
    public void writeFile(List<E> dataList, String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dataList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<E> readFile(String fileName){
        List<E> eList = new ArrayList<>();
        File file = new File(fileName);
        if(file.length()>0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                eList = (List<E>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return eList;
    }
}
