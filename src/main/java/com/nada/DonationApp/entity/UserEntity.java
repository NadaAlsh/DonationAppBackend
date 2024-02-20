package com.nada.DonationApp.entity;

import com.nada.DonationApp.util.enums.BloodType;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullName", nullable = false)
    private String fullName;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "bloodType", nullable = false)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @Column(name = "civilId", nullable = false)
    private String civilId;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "age", nullable = false)
    private int age;


    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roles;

    public RoleEntity getRoles() {
        return roles;
    }

    public void setRoles(RoleEntity roles) {
        this.roles = roles;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getFullName() {
        return fullName;
    }

    public void setFullName(java.lang.String fullName) {
        this.fullName = fullName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCivilId() {
        return civilId;
    }

    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}

