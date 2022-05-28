package com.example.task.service;

import com.example.task.dto.WorkItemDtoConverter;
import com.example.task.repository.WorkItemRepository;
import org.junit.Before;
import org.mockito.Mockito;

public class WorkItemServiceTest {

    private WorkItemService workItemService;
    private WorkItemRepository workItemRepository;
    private WorkItemDtoConverter workItemDtoConverter;

    @Before
    public void setUp() throws Exception{

        workItemRepository = Mockito.mock(WorkItemRepository.class);

        workItemService = new WorkItemService(workItemRepository, workItemDtoConverter);

    }

    /*@Test
    public void whenAddItemCalledWith*/
}