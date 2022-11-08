package com.example.demo.model;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Long Reputation;
    @OneToMany
    private List<Orders> ordersList;
    @OneToMany
    private List<Executed> executed;
    @ToString.Include
    @ManyToOne
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && surname.equals(user.surname) && email.equals(user.email) && password.equals(user.password) && Objects.equals(Reputation, user.Reputation) && Objects.equals(ordersList, user.ordersList) && Objects.equals(executed, user.executed) && role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, Reputation, ordersList, executed, role);
    }
}
