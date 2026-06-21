package com.example.farm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(length = 255)
    private String pwd;

    public Integer getId(){return id;} public void setId(Integer i){this.id=i;}
    public String getUsername(){return username;} public void setUsername(String u){this.username=u;}
    public String getPwd(){return pwd;} public void setPwd(String p){this.pwd=p;}
}
