package com.example.task.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateWorkItemRequest {

    private String title;

    private String description;

}
