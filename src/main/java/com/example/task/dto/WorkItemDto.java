package com.example.task.dto;

import lombok.Data;


import java.time.LocalDateTime;


@Data
public class WorkItemDto {

    //private LocalDateTime created;
    private String title;
    private String description;

    public WorkItemDto(/*LocalDateTime created,*/ String title, String description) {
    }
}
