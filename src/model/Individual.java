package model;

public class Individual extends Customer{
    private int individualID;

    public Individual(String fn, String ln, String un, String pw) {
        super(fn + " " + ln, un, pw);
    }
}
