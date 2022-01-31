package com.amdocs.project.techademy.model;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column(name = "c_name")
    private String cName;

    @Column(name = "c_desp")
    private String cDesp;

    @Column(name = "c_fees")
    private String cFees;

    @Column(name = "c_resource")
    private byte[] cResource;

    public Course(){
    }

    public Course(String cName, String cDesp, String cFees, byte[] cResource) {
        this.cName = cName;
        this.cDesp = cDesp;
        this.cFees = cFees;
        this.cResource = cResource;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDesp() {
        return cDesp;
    }

    public void setcDesp(String cDesp) {
        this.cDesp = cDesp;
    }

    public String getcFees() {
        return cFees;
    }

    public void setcFees(String cFees) {
        this.cFees = cFees;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public byte[] getcResource() {
        return cResource;
    }

    public void setcResource(byte[] cResource) {
        this.cResource = cResource;
    }
}
