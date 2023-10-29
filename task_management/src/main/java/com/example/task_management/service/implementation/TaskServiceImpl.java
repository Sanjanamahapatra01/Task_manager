package com.example.task_management.service.implementation;

import com.example.task_management.model.Tasks;
import com.example.task_management.repository.TaskRepository;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    public TaskRepository taskRepository;
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Tasks> getTaskByUser(String user) {
        return taskRepository.findByUserName(user);
    }

    @Override
    public Optional<Tasks> getTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateTask(Tasks tasks) {
        taskRepository.save(tasks);
    }

    @Override
    public void addTask(Tasks tasks) {
        taskRepository.save(tasks);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void saveTask(Tasks tasks) {
        taskRepository.save(tasks);
    }

    @Override
    public void findByid(Long id) {
        taskRepository.findById(id).get();
    }

    @Override
    public void update(Tasks tasks) {
        taskRepository.save(tasks);
    }
}
