package com.example.demo.model.dto;

import lombok.Builder;
import lombok.NonNull;
@Builder

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Long Reputation;
    private String role;

    public UserDTO(Long id, String name, String surname, String email, Long reputation,String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.Reputation = reputation;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getReputation() {
        return Reputation;
    }

    public void setReputation(Long reputation) {
        Reputation = reputation;
    }
}
