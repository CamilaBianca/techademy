package com.amdocs.project.techademy.model;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column
    private String name;

    @Column(name = "Phone_no")
    private String phoneNo;

    @Column
    private String email;

    @Column
    private String messege;

    public Contact(){
    }

    public Contact(User user, String name, String phoneNo, String email, String messege) {
        this.user = user;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.messege = messege;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
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

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
