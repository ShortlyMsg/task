package com.example.task.repository;

import com.example.task.entity.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

}
