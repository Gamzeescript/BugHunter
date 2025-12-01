package com.gamzeescript.huntinguknown.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean completed = false;

    public Task() {} // Necesario para JPA
    public Task(String description) { this.description = description; }

    
}
