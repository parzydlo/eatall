package model;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String username;
    private String password;

    public User(){
        name = "";
        username="";
        password="";
    }

    public User(String fName, String userName, String password) {
        name = fName;
        username = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
