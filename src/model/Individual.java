package model;

public class Individual extends Customer{
    private int individualID;
    private String door, street, postcode;

    public Individual(String fn, String ln, String un, String pw, String door, String street, String postcode) {
        super(fn + " " + ln, un, pw);
        this.door = door;
        this.street = street;
        this.postcode = postcode;
    }

    public Individual(String fn, String ln, String un, String pw) {
        this(fn, ln, un, pw, "", "", "");
    }

    public void setDoor(String door) {
        this.door = door;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getDoor() {
        return this.door;
    }
    public String getStreet() {
        return this.street;
    }
    public String getPostcode() {
        return this.postcode;
    }
}
