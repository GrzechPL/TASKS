package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")

public class TaskController {

    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/tasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/tasks/{taskId}")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException{
        return taskMapper.maptotaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/tasks/{taskId}")
    public void deleteTask(@RequestParam Long taskId){
        service.deleteTaskBy(taskId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        return taskMapper.maptotaskDto(service.saveTask(taskMapper.maptotask(taskDto)));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/tasks",consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto){
    service.saveTask(taskMapper.maptotask(taskDto));
    }
}

