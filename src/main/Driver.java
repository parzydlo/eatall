package main;

public class Driver extends User {
    private int driverID;

    public Driver(String fn, String ln, String un, String pw, int uid){
        super(fn, ln, un, pw, uid);
        this.driverID=uid;
    }
    public int getDriverID(){
        return driverID;
    }
    public void setDriverID(int driverid){
        this.driverID=driverid;
    }
}
