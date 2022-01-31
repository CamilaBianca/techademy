package com.amdocs.project.techademy.model;

import javax.persistence.*;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int f_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String feedback;

    public Feedback(){
    }

    public Feedback(User user, String name, String email, String feedback) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
}
