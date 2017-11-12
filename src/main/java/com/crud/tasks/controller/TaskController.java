package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getTasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

   // @RequestMapping(method = RequestMethod.GET,value = "getTask")
   // public TaskDto getTask(Long taskId){
   //     return taskMapper.maptotaskDto(service.getTaskByID(taskId));
   // }
    //@RequestMapping(method = RequestMethod.DELETE,value = "deleteTask")
    //public void deleteTask(String taskId){
    //}
    //@RequestMapping(method = RequestMethod.PUT,value = "updateTasks")
    //public TaskDto updateTask(TaskDto taskDto){
     //   return new TaskDto((long)1,"change title","change content");
    //}
    //@RequestMapping(method = RequestMethod.PUT,value = "createTask")
    //public void createTask(TaskDto taskDto){
    //}
}

