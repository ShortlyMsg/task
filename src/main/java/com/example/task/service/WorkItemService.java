package com.example.task.service;


import com.example.task.dto.CreateWorkItemRequest;
import com.example.task.dto.UpdateWorkItemRequest;
import com.example.task.dto.WorkItemDtoConverter;
import com.example.task.dto.WorkItemDto;
import com.example.task.entity.WorkItem;
import com.example.task.exception.WorkItemNotFoundException;
import com.example.task.repository.WorkItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WorkItemService {

    private final WorkItemRepository workItemRepository;
    private final WorkItemDtoConverter workItemDtoConverter;

    public WorkItemService(WorkItemRepository workItemRepository,
                           WorkItemDtoConverter workItemDtoConverter) {
        this.workItemRepository = workItemRepository;
        this.workItemDtoConverter = workItemDtoConverter;
    }

    public List<WorkItemDto> getAllWorkItems() {
         return workItemRepository.findAll()
                 .stream()
                 .map(WorkItemDtoConverter::convert).collect(Collectors.toList());
    }

    public WorkItemDto getWorkItemById(long id) {
        WorkItem workItem = findWorkItemById(id);
        return WorkItemDtoConverter.convert(workItem);
    }

    public WorkItemDto createWorkItem(CreateWorkItemRequest workItemRequest) {
        WorkItem workItem = new WorkItem();
        workItem.setTitle(workItemRequest.getTitle());
        workItem.setDescription(workItemRequest.getDescription());
        workItem.setCreated(LocalDateTime.now());
        return WorkItemDtoConverter.convert(workItemRepository.save(workItem));
    }


    public List<WorkItem> getWorkItems() {
        return workItemRepository.findAll();
    }

    public WorkItem addItem(WorkItem workItem) {
        return workItemRepository.save(workItem);
    }


    public WorkItemDto updateWorkItem(long id, UpdateWorkItemRequest updateWorkItemRequest) {
        WorkItem workItem = findWorkItemById(id);
        WorkItem updatedWorkItem = new WorkItem(workItem.getId(),
                workItem.getCreated(),
                workItem.getTitle(),
                workItem.getDescription(),
                false);
        return WorkItemDtoConverter.convert(workItemRepository.save(updatedWorkItem));
    }

    private WorkItem findWorkItemById(Long id){
        return workItemRepository.findById(id)
                .orElseThrow(()-> new WorkItemNotFoundException("Work Item couldn't be found by following id: " +id));
    }

}
