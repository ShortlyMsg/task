package com.example.task.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateWorkItemRequest {

    private String title;

    private String description;
}
