package model;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class BusinessList implements Serializable {

    private static final long serialVersionUID = 1L;


    private static BusinessList businessList = null;
    private ArrayList<Business> businessArrayList;

    public ArrayList<Business> getLastQuery() {
        return lastQuery;
    }

    private void setLastQuery(ArrayList<Business> lastQuery) {
        this.lastQuery = lastQuery;
    }

    private ArrayList<Business> lastQuery;

	private BusinessList() {
        // Exists only to defeat instantiation.
//        businessArrayList = UserList.getInstance().getBusinessList();
//        lastQuery = businessArrayList;
        Business[] predefinedBusinesses = {
                new Business("Nandos", "NandosUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("Dominos", "DominosUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("KFC", "KFCUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("Peri Peri", "PeriPeriUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("Subway", "SubwayUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("Kitchen Pizzeria", "KitchenPizzeriaUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("Pizza Pizza", "PizzaPizzaUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
                new Business("FFC", "FFCUsername", "asdf", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Mile End Road", "E1 4PQ"),
        };
        businessArrayList = new ArrayList<Business>(Arrays.asList(predefinedBusinesses));
    }

	public static BusinessList getInstance() {
        if(businessList == null){
            businessList = new BusinessList();
        }
	    return businessList;
	}

	public ArrayList<Business> getBusinessArrayList() {
        return businessArrayList;
    }

	public void searchByName(String name) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : businessArrayList)
            if(b.getBusinessname().toLowerCase().contains(name.toLowerCase()))
                results.add(b);
        lastQuery = results;
	}

    public void searchByCategory(ArrayList<String> categories) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : businessArrayList)
           //b.

                results.add(b);
        lastQuery = results;
    }

    public ArrayList<Business> searchByLocation(String name) {
        ArrayList<Business> results = new ArrayList<Business>();
        for(Business b : businessArrayList)
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