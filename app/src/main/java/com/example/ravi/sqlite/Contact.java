package com.example.ravi.sqlite;

/**
 * Created by Ravi on 16-10-2016.
 */

public class Contact
{


    String user;
    String email;
    String password;
    public Contact(String user, String email) {
        this.email = email;
        this.password = password;
        this.user = user;


    }




    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
