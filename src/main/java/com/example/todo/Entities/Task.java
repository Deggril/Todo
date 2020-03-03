package com.example.todo.Entities;

import javax.persistence.*;

@Entity
public class Task {
    private int id;
    private String name;
    private Integer is_done;
    private User user;


    public Task() {
    }

    public Task(String name, Integer isDone, User user) {
        this.name = name;
        this.is_done = isDone;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    public String getName() {return name; }
    public void setName(String name) {this.name = name; }

    public Integer getIs_done() {return is_done;}
    public void setIs_done(Integer is_done) {this.is_done = is_done;}

    @ManyToOne(targetEntity = User.class, optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
