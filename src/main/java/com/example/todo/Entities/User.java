package com.example.todo.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private int id;
    private String name;
    private String password;
    private Role role;
    private List<Task> tasks;


    public User() {}

    public User(String name, String password, Role role, List<Task> tasks) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.tasks = tasks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(targetEntity = Role.class,optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "user",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Task> getTasks() { return tasks;  }
    public void setTasks(List<Task> tasks) {this.tasks = tasks; }





}
