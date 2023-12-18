package com.incedo.capstone.smartinventory.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Godowns  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location = null;
    private Double capacityInQuintals = null;
    private LocalDate startDate = null;

    @OneToOne(optional = false)
    @JoinColumn(name= "employee_name")
    private Users users;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Double getCapacityInQuintals() {
        return capacityInQuintals;
    }
    public void setCapacityInQuintals(Double capacityInQuintals) {
        this.capacityInQuintals = capacityInQuintals;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Godowns{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", capacityInQuintals=" + capacityInQuintals +
                ", startDate=" + startDate +
                ", users=" + users +
                '}';
    }
}
