package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    private String title;
    @OneToMany
    private List<Image> imageList;
    @OneToOne
    private User user_author;
    @OneToMany
    private List<User> users_senders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public User getUser_author() {
        return user_author;
    }


    public void setUserAuthor(User user_author) {
        this.user_author = user_author;
    }

    public List<User> getUsersSenders() {
        return users_senders;
    }

    public void setUsersSenders(List<User> users_senders) {
        this.users_senders = users_senders;
    }

    public void addUserSenders(User user){
        this.users_senders.add(user);
    }
}
