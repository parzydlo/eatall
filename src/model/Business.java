package model;


import java.util.ArrayList;

public class Business extends Customer {
    private String description;
    private String street;
    private String postcode;
    private int rating;
    private ArrayList<Item> items;
    private ArrayList<String> revs;
    private String businessname;


    public Business(String bName, String userName, String password, String description, String street, String postcode) {
        super(bName, userName, password);
        businessname = bName;
        items = new ArrayList<>();
        revs = new ArrayList<>();
        setDescription(description);
        setStreet(street);
        setPostcode(postcode);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<String> getRevs() {
        return revs;
    }

    public void setRevs(String review){
        revs.add(review);
        UserList.getInstance().updateUserListFile();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String name) {
        businessname = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rate) {
        rating = rate;
    }

    public void addItem(Item I) {
        items.add(I);
        UserList.getInstance().updateUserListFile();
    }

    public void removeItem(Item I) {
        items.remove(I);
        UserList.getInstance().updateUserListFile();
    }



}
