package main;

public class Business extends Customer{
    private String businessname;
    private int rating;
    private int businessID;

    public Business(String fn, String ln, int id, String bn, int rate){
        super(fn, ln, id);
        businessname=bn;
        rating=rate;
        businessID=id;
    }

    public String getBusinessname(){
        return businessname;
    }
    public void setBusinessname(String name){
        businessname=name;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rate){
        rating=rate;
    }
    public int getBusinessID(){
        return businessID;
    }
}
