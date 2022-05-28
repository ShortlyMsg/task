package com.example.task.controller;


import com.example.task.dto.CreateWorkItemRequest;
import com.example.task.dto.UpdateWorkItemRequest;
import com.example.task.dto.WorkItemDto;
import com.example.task.entity.WorkItem;
import com.example.task.repository.WorkItemRepository;
import com.example.task.service.WorkItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/workitem")
public class WorkItemController {

    private final WorkItemRepository workItemRepository;
    private final WorkItemService workItemService;


    public WorkItemController(WorkItemRepository workItemRepository,
                              WorkItemService workItemService) {
        super();
        this.workItemRepository = workItemRepository;
        this.workItemService = workItemService;
    }

    /*@GetMapping("/get")
    public List<WorkItem> getWorkItems(){
        return this.workItemService.getWorkItems();
    }*/

    @PostMapping("/add")
    public WorkItem addWorkItem(@RequestBody WorkItem workItem){
        return this.workItemService.addItem(workItem);
    }

    @PostMapping
    public ResponseEntity<WorkItemDto> createWorkItem(@RequestBody CreateWorkItemRequest workItemRequest) {
        return ResponseEntity.ok(workItemService.createWorkItem(workItemRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkItemDto> updateWorkItem(
            @PathVariable Long id,
            @RequestBody UpdateWorkItemRequest updateWorkItemRequest){
        return ResponseEntity.ok(workItemService.updateWorkItem(id, updateWorkItemRequest));
    }

/*    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteWorkItem(@PathVariable long id){
        workItemService.deleteWorkItem(id);
        return ResponseEntity.ok().build();
    }*/


    @GetMapping
    public ResponseEntity<List<WorkItemDto>> getAllWorkItems() {
        return ResponseEntity.ok(workItemService.getAllWorkItems());
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkItemDto> getWorkItemById(@PathVariable long id){
        return  ResponseEntity.ok(workItemService.getWorkItemById(id));
    }




}
