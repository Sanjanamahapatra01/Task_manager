package com.example.task_management.repository;

import com.example.task_management.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks,Long> {
    List<Tasks> findByUserName(String userName);
}
