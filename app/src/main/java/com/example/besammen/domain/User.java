package com.example.besammen.domain;
public class User {
    private String userName;
    private String gender;
    private int age;
    private String diagnosis;

    public User(String userName, String gender, int age, String diagnosis) {
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
