package com.gamzeescript.huntinguknown.repository;

import com.gamzeescript.huntinguknown.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Spring Data JPA automáticamente implementa métodos como save(), findById(), etc.
}
