package com.example.task_management.controller;

import com.example.task_management.model.Tasks;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }
    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<Tasks> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "view-task";
    }




}
