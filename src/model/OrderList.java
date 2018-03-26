package model;

import java.io.*;
import java.util.ArrayList;

public class OrderList implements Serializable {

    private static OrderList instance = null;
    private ArrayList<Order> orderArrayList;

    private OrderList() {
        orderArrayList = new ArrayList<>();
    }

    public static OrderList getInstance() {
        if (instance == null) {
            try {
                System.out.println("creating");
                // read object from file
                FileInputStream fis = new FileInputStream("OrderList.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                instance = (OrderList) ois.readObject();
                ois.close();
                fis.close();
//                instance.printAll();
            } catch (FileNotFoundException e) {
                System.out.println("No File to read");
                instance = new OrderList();
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return instance;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public ArrayList<Order> getBusinessOrders(Business b) {
        ArrayList<Order> results = new ArrayList<>();
        for (Order o : orderArrayList) {
            if (o.getSeller() == b) {
                results.add(o);
            }
        }
        return results;
    }

    public ArrayList<Order> getIndividualOrders(Individual i) {
        ArrayList<Order> results = new ArrayList<>();
        for (Order o : orderArrayList) {
            if (o.getBuyer() == i) {
                results.add(o);
            }
        }
        return results;
    }

    public void addOrder(Order o) {
        orderArrayList.add(o);
        updateOrderListFile();
    }

    public void removeOrder(Order o) {
        orderArrayList.remove(o);
        updateOrderListFile();
    }

    public void updateOrderListFile() {
        System.out.println("update");

        /// write object to file
        try {
            FileOutputStream fos = new FileOutputStream("OrderList.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("No File");
        }
    }

}
