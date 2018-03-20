package main;

public class Customer extends User{
    private int customerID=0;

    public Customer(String fn, String ln, int uid){
        super(fn, ln, uid);
        customerID=uid;
    }
    public int getCustomerID(){
        return customerID;
    }
}
