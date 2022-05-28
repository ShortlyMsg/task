package com.example.task.dto;

import com.example.task.entity.WorkItem;
import org.springframework.stereotype.Component;

@Component
public class WorkItemDtoConverter {

    public static WorkItemDto convert(WorkItem from){
        return new WorkItemDto(/*from.getCreated(),*/ from.getTitle(), from.getDescription());
    }
}
