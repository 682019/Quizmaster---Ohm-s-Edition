package com.example.servingwebcontent.entities;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class UserStuff {
    private static ArrayList<User> users = new ArrayList<User>();
    private static final String PATH = "complete\\src\\users.dat";



    public static void readUsers() {
     try {
        FileInputStream fileIn = new FileInputStream(PATH);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        User[] userArr = (User[]) objectIn.readObject(); 
        users = new ArrayList<>(Arrays.asList(userArr)); 
        objectIn.close();
        fileIn.close();
        }catch (EOFException e) {
            System.out.println("No users found");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void writeUsers() {
    try {
        FileOutputStream fileOut = new FileOutputStream(PATH);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); 
        Object[] userObject = users.toArray(); //converts arraylist to array
        objectOut.writeObject(userObject); 
        objectOut.close();
        fileOut.close();

      System.out.println("Data saved in " + PATH);
    } catch (Exception e) {
      e.printStackTrace();
    }
    }

    // public static void main(String[] args) {
    //     // User user = new User();
    //     // user.setName("John");
    //     // user.setEmail("John.email.com");
    //     // users.add(user);
    //     // saveUsers();

    //     loadUsers();
    //     System.out.println(users.get(0).getName());
    // }






}
