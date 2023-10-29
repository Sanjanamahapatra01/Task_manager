package com.example.task_management.controller;

import com.example.task_management.model.Tasks;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class  AdminController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome-admin";
    }

    @GetMapping("/add")
    public String addData() {
        return "add-task";
    }
    @PostMapping("/add")
    public String addTask(Tasks task) {
        taskService.saveTask(task);
        return "redirect:/admin/all";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model) {
        Optional<Tasks> task = taskService.getTaskById(id);
        model.addAttribute("task",task);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String editNow(@ModelAttribute("task") Tasks task){
        taskService.update(task);
        return "redirect:/admin/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/admin/all";
    }
    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<Tasks> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }
}
