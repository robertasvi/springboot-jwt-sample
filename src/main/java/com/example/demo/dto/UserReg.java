package com.example.demo.dto;

public class UserReg {
    String firstname;
    String surname;
    String email;
    String phone;
    String password;

    public UserReg(String firstname, String surname, String email, String phone, String password) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
