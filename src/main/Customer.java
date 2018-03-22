package main;

public class Customer extends User{
    private int customerID=0;

    public Customer(String fn, String ln, String un, String pw, int uid){
        super(fn, ln, un, pw, uid);
        customerID=uid;
    }
    public int getCustomerID(){
        return customerID;
    }
}
