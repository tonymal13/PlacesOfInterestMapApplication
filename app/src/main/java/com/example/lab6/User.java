package com.example.lab6;

public class User {
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String get_name(){
        return name;
    }
    public String get_surname(){
        return surname;
    }
    public String get_email(){
        return email;
    }
    public void set_name(String name){
        this.name = name;
    }
    public void set_surname(String surname){
        this.surname = surname;
    }
    public void set_email(String email){
        this.email = email;
    }
}
