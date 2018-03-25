package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    private String name;
    private String description;
    private double cost;
    private boolean available;

    public ArrayList<String> getCategories() {
        return categories;
    }

    private ArrayList<String> categories;

    public Item(String name, int price, String description) {
        setName(name);
        setCost(price);
        setAvailable(true);
        categories = new ArrayList<>();
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
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