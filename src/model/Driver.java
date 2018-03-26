package model;

public class Driver extends User {
    public Driver(String fn, String ln, String un, String pw) {
        super(fn + " " + ln, un, pw);
    }
}
