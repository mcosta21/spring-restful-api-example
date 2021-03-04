package com.mcosta21.springrestfulapiexample.controller.request;

public class StudentRequest {
    
    private Long id;
    private String name;
    private String address;
    private String discipline;
    
    public StudentRequest(Long id, String name, String address, String discipline) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.discipline = discipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    
}
