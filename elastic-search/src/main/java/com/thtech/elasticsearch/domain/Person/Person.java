package com.thtech.elasticsearch.domain.Person;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test")
public class Person {

    @Id
    private String name;
    private String lastName;
    private String lifeHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLifeHistory() {
        return lifeHistory;
    }

    public void setLifeHistory(String lifeHistory) {
        this.lifeHistory = lifeHistory;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lifeHistory='" + lifeHistory + '\'' +
                '}';
    }
}
