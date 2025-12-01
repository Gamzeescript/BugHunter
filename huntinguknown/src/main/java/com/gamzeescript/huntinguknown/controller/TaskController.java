package com.gamzeescript.huntinguknown.controller;

import com.gamzeescript.huntinguknown.model.Task;
import com.gamzeescript.huntinguknown.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        // Devuelve el código HTTP 201 (Created)
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED); 
    }
}
