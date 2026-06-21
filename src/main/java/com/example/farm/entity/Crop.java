package com.example.farm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crop")
public class Crop {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer landId;
    private String cropName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate sowTime;
    private String cycle;
    private String output;

    public Integer getId(){return id;} public void setId(Integer i){this.id=i;}
    public Integer getLandId(){return landId;} public void setLandId(Integer l){this.landId=l;}
    public String getCropName(){return cropName;} public void setCropName(String c){this.cropName=c;}
    public LocalDate getSowTime(){return sowTime;} public void setSowTime(LocalDate d){this.sowTime=d;}
    public String getCycle(){return cycle;} public void setCycle(String c){this.cycle=c;}
    public String getOutput(){return output;} public void setOutput(String o){this.output=o;}
}
