package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    int quantity;
    private String name;
    private String description;
    private double cost;
    private boolean available;
    private ArrayList<String> categories;
    public Item(String name, double price, int quantity, String description) {
        setName(name);
        setCost(price);
        setAvailable(true);
        setQuantity(quantity);
        categories = new ArrayList<>();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}