package service;

import com.example.todo.Entities.Task;
import com.example.todo.Entities.User;
import dao.UserDao;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(String name) {
        return usersDao.findByName(name);
    }

    public void saveTask(Task user) {
        usersDao.save(user);
    }

    public void deleteTask(Task user) {
        usersDao.delete(user);
    }

    public void updateTask(Task user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public List findAllTasks() {
        return usersDao.findAllTasks();
    }
}