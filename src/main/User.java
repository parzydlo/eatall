package main;

public class User {
    private String firstname;
    private String lastname;
    private int userID;

    public User(){
        firstname="";
        lastname="";
        userID=0;
    }
    public User(String fn, String ln, int uid){
        firstname=fn;
        lastname=ln;
        userID=uid;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public int getUserID(){
        return userID;
    }
}
