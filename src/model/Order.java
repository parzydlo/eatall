package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private Business seller;
    private Individual buyer;
    private Date timestamp;
    private ArrayList<Item> items;

    public Order(Business s, Individual b) {
        timestamp = Date.from(Instant.now());
        seller = s;
        buyer = b;
        items = new ArrayList<Item>();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void removeitem(Item i) {
        items.remove(i);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Item i : items) {
            total += i.getCost();
        }
        return total;
    }

    public Individual getBuyer() {
        return buyer;
    }

    public Business getSeller() {
        return seller;
    }

}
