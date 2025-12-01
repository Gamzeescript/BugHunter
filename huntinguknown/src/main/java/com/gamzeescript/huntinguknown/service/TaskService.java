package com.gamzeescript.huntinguknown.service;

import com.gamzeescript.huntinguknown.model.Task;
import com.gamzeescript.huntinguknown.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Inyección de dependencia vía constructor (preferido)
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        // Podrías tener lógica de validación aquí
        return taskRepository.save(task);
    }
}
    
