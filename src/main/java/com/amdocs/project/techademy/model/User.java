package com.amdocs.project.techademy.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column
    private String email;

    @Column
    private String address;

    @Column(name = "reg_date")
    private LocalDate regDate = LocalDate.now();

    @Column
    private String password;

    @Lob
    @Column(name = "upload_photo")
    private byte[] uploadPhoto;

    public User(){
    }

    public User(String name, String phoneNo, String email, String address, LocalDate regDate, String password, byte[] uploadPhoto) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.regDate = regDate;
        this.password = password;
        this.uploadPhoto = uploadPhoto;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(byte[] uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }
}


