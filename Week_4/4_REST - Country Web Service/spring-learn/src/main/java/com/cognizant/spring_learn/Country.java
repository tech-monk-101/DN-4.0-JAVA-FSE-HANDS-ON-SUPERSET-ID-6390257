package com.cognizant.spring_learn;

public class Country {
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country : " + name;
    }
}