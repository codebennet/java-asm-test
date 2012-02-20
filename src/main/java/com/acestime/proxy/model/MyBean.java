package com.acestime.proxy.model;


public class MyBean {

    public void authorize(boolean valid) {

        if (valid) {
            System.out.println("User is valid!");
        } else {
            System.out.println("User is NOT valid!");
        }
    }
}