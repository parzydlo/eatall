package main;

public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int userID;

    public User(){
        firstname="";
        lastname="";
        username="";
        password="";
        userID=0;
    }
    public User(String fn, String ln, String un, String pw, int uid){
        firstname=fn;
        lastname=ln;
        username=un;
        password=pw;
        userID=uid;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getUserID(){
        return userID;
    }
}
