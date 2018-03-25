package model;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class BusinessList implements Serializable {

    private static final long serialVersionUID = 1L;


    private static BusinessList businessList = null;
    private static ArrayList<Business> buisnessArrayList;

    public ArrayList<Business> getLastQuery() {
        return lastQuery;
    }

    private void setLastQuery(ArrayList<Business> lastQuery) {
        this.lastQuery = lastQuery;
    }

    private ArrayList<Business> lastQuery;

	private BusinessList() {
        // Exists only to defeat instantiation.
        buisnessArrayList = UserList.getInstance().getBuisnessList();
        lastQuery = buisnessArrayList;
	}

	public static BusinessList getInstance() {
        if(businessList == null){
            businessList = new BusinessList();
        }
        buisnessArrayList = UserList.getInstance().getBuisnessList();
	    return businessList;
	}

	public void searchByName(String name) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : buisnessArrayList)
            if(b.getBusinessname().toLowerCase().contains(name.toLowerCase()))
                results.add(b);
        lastQuery = results;
	}

    public void searchByCategory(ArrayList<String> categories) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : buisnessArrayList)
           //b.

                results.add(b);
        lastQuery = results;
    }

    public ArrayList<Business> searchByLocation(String name) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : buisnessArrayList)
            if(b.getBusinessname().toLowerCase().contains(name))
                results.add(b);
        return results;
    }

    public void addBuisness(Business b)
    {
        UserList.getInstance().addUser(b);
    }

    public void removeBuisness(Business b)
    {
        UserList.getInstance().removeUser(b);
    }
}