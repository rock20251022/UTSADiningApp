package edu.utsa.cs3443.utsadining;

import javax.swing.*;

public class Restaurant {
    private String name;
    private String location;
    private String description;
    private String hours;
    private String imagePath;

    public Restaurant(String name, String location, String description, String hours, String imagePath) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.hours = hours;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }



}


