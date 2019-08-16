package com.example.mkorganizer.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "keyboards")
public class Keyboard {

    // Table of database

    @PrimaryKey
    private int id;

    private String brand;
    private String model;
    private String switches;

    // Get and Set

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSwitches() {
        return switches;
    }

    public void setSwitches(String switches) {
        this.switches = switches;
    }

}
