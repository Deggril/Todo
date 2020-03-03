package com.example.todo.controller;

import com.example.todo.Entities.Task;
import com.example.todo.Entities.User;
import com.example.todo.exceptions.NotFoundException;
import dao.UserDao;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tasks")
public class TaskController {

    UserService userService = new UserService();
    Map<String, User> users;
    private int counter = 4;

    @GetMapping("{id}?pass")
    public String Authorization(String name, String password) {
        User user = userService.findUser(name);
        if(user.getPassword() == password)
        {
            String token = Long.toHexString(Double.doubleToLongBits(Math.random()));
            users.put(token, user);
            return token;
        }
        else
        {
            return null;
        }
    }

    private User getUser(String token){
        return users.get(token);
    }
    public List<Task> GetTasks() {
        return null;
        //return taskService.list();
    }

    @GetMapping("{id}")
    public Task getOne(@PathVariable int id) {
        return getMessage(id);
    }

    private Task getMessage(int id) {
        return GetTasks().stream()
                .filter(message -> message.getId() ==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Task create(@RequestBody Task message) {
        //message.setId(counter++);

        GetTasks().add(message);

        return message;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable int id, @RequestBody Task message) {
       Task messageFromDb = getMessage(id);

        messageFromDb.setName(message.getName());
        messageFromDb.setIs_done(message.getIs_done());

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Task message = getMessage(id);

        GetTasks().remove(message);
    }
}
