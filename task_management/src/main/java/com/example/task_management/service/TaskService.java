package com.example.task_management.service;

import com.example.task_management.model.Tasks;
import org.springframework.scheduling.config.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Tasks> getAllTasks();
    List<Tasks> getTaskByUser(String user);
    Optional<Tasks> getTaskById(long id);
    void updateTask(Tasks tasks);
    void addTask(Tasks tasks);
    void deleteTask( Long id);
    void saveTask(Tasks tasks);

    void findByid(Long id);

    void update(Tasks tasks);
}
