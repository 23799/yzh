package com.example.farm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "land")
public class Land {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String landName;
    private String area;
    private String soilType;
    private String farmer;

    public Integer getId(){return id;} public void setId(Integer i){this.id=i;}
    public String getLandName(){return landName;} public void setLandName(String s){this.landName=s;}
    public String getArea(){return area;} public void setArea(String a){this.area=a;}
    public String getSoilType(){return soilType;} public void setSoilType(String s){this.soilType=s;}
    public String getFarmer(){return farmer;} public void setFarmer(String f){this.farmer=f;}
}
