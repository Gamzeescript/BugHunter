package com.gamzeescript;

import org.junit.jupiter.api.Test;

import com.gamzeescript.huntinguknown.controller.TaskController;
import com.gamzeescript.huntinguknown.model.Task;
import com.gamzeescript.huntinguknown.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TaskController.class) // ¡El arma Ninja! Solo carga el controlador.
public class TaskControllerTest {
    
@Autowired
    private MockMvc mockMvc; // Utilidad para simular peticiones HTTP

    // Reemplazamos la implementación real de TaskService con un Mock
    @SuppressWarnings("removal")
    @MockBean 
    private TaskService taskService; 

    @Test
    void shouldCreateNewTaskAndReturn201() throws Exception {
        
        // 1. Arrange (Preparación): Simula la respuesta del Servicio
        Task newTask = new Task("Terminar presentación");
        when(taskService.createTask(any(Task.class))).thenReturn(newTask);

        String taskJson = "{\"description\": \"Terminar presentación\"}";

        // 2. Act (Acción): Simula la llamada POST
        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskJson))
        
        // 3. Assert (Verificación): Confirma el resultado de la API
            .andExpect(status().isCreated()); // Esperamos un código HTTP 201
    }
}
