package model;

import java.io.*;
import java.util.ArrayList;


public class UserList implements Serializable {


    private static UserList userList = null;
    private ArrayList<User> userArrayList;

    private UserList() {
        // Exists only to defeat instantiation.
        userArrayList = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (userList == null) {
            try {
                System.out.println("creating");
                // read object from file
                FileInputStream fis = new FileInputStream("UserList.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (UserList) ois.readObject();
                ois.close();
                userList.printAll();
            } catch (FileNotFoundException e) {
                System.out.println("No File to read");
                userList = new UserList();
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return userList;
    }


    public void addUser(User u) {
        userArrayList.add(u);
        printAll();
        updateUserListFile();
    }

    public void removeUser(User u) {
        userArrayList.remove(u);
        printAll();
        updateUserListFile();
    }

    public ArrayList<Business> getBuisnessList() {
        ArrayList<Business> buisnessArrayList = new ArrayList<>();
        for (User u : userArrayList)
            if (u instanceof Business)
                buisnessArrayList.add((Business) u);
        return buisnessArrayList;
    }

    private void updateUserListFile() {
        System.out.println("update");

        /// write object to file
        try {
            FileOutputStream fos = new FileOutputStream("UserList.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
        } catch (Exception e) {
            System.out.println("No File");
        }
    }

    public void printAll() {
        for (User u : userArrayList)
            System.out.println(u.getUsername());
    }

    public boolean isUsernameTaken(String username) {
        System.out.println("1");
        for (User u : userArrayList) {
            System.out.println("1");
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyCredentials(String username, String password) {
        for (User u : userArrayList)
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password))
                return true;
        return false;
    }


}