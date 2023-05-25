package com.example.besammen.domain;
public class User {
    private String email;
    private String password;
    private String userName;
    private String gender;
    private String age;
    private String diagnosis;

    public User(String email, String password, String userName, String gender, String age, String diagnosis) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
