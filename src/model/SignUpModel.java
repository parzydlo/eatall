package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class SignUpModel {
    Connection connection;
    
    public SignUpModel(){
       connection = SQLiteConnection.Connector();
       if(connection == null){
           System.out.println("Cannot connect to Data Base.");
       } 
    }
    
    public boolean isConnected(){
        try{
            return !connection.isClosed();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public String[] getData(String user, String pass)throws SQLException{
        PreparedStatement preparedS = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        try{
            preparedS = connection.prepareStatement(query);
            preparedS.setString(1, user);
            preparedS.setString(2, pass);
            
            resultSet = preparedS.executeQuery();
            
            if(resultSet.next()){
                String[] list = new String[6];
                list[0] = resultSet.getString("USERNAME");
                list[1] = resultSet.getString("PASSWORD");
                list[2] = resultSet.getString("FNAME");
                list[3] = resultSet.getString("LNAME");
                list[4] = resultSet.getString("ACCTYPE");
                return list;
            } else return null;
        }catch(Exception e){
            System.out.println(e);
            return null;
            
        } finally {
            preparedS.close();
            resultSet.close();
        }
    }
    
    public boolean checkUsername(String username) throws SQLException{
        boolean exists = false;
        PreparedStatement preparedS = null;
        ResultSet resultSet = null;
        String query = "SELECT USERNAME FROM USERS WHERE USERNAME = ?";
        try{
            preparedS = connection.prepareStatement(query);
            preparedS.setString(1, username);
            
            resultSet = preparedS.executeQuery();
            
            if(resultSet.next()){
                if(username.equals(resultSet.getString("USERNAME"))) exists = true;
                System.out.println(exists);
            }
        }catch(Exception e){
            System.out.println(e);
            return false;
            
        } finally {
            preparedS.close();
            resultSet.close();
            return exists;
        }
    }

    public void addToDB(String fName, String lName, String user, String pass, String flag) throws SQLException{
        PreparedStatement preparedS = null;
        
        String query = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?)";
        
        try{
            preparedS = connection.prepareStatement(query);
            preparedS.setString(1, user);
            preparedS.setString(2, pass);
            preparedS.setString(3, fName);
            preparedS.setString(4, lName);
            preparedS.setString(5, flag);
            preparedS.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
            
        } finally {
            preparedS.close();
        }
    }
}