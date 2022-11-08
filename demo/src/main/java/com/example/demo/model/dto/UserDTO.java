package com.example.demo.model.dto;

import lombok.Builder;
import lombok.NonNull;
@Builder

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Long Reputation;

    public UserDTO(Long id, String name, String surname, String email, String password, Long reputation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.Reputation = reputation;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getReputation() {
        return Reputation;
    }

    public void setReputation(Long reputation) {
        Reputation = reputation;
    }
}
