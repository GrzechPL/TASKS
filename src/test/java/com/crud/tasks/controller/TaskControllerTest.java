package com.crud.tasks.controller;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void getTask() throws Exception {
        //Given
        Task task =new Task(
                1L,
                "TaskDto",
                "Content of TaskDto");

        TaskDto taskDto =new TaskDto(
                1L,
                "TaskDto",
                "Content of TaskDto");


        when(service.getTask(1L)).thenReturn(Optional.ofNullable(task));
        when(taskMapper.maptotaskDto(ArgumentMatchers.any())).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))//or isOk()
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.title",is("TaskDto")))
                .andExpect(jsonPath("$.content",is("Content of TaskDto")));
    }

    @Test
    public void getTasks() throws Exception {
        //Given
        Task task =new Task(
                1L,
                "TaskDto",
                "Content of TaskDto");
        List<Task>listTask = new LinkedList<>();
        listTask.add(task);

        TaskDto taskDto =new TaskDto(
                1L,
                "TaskDto",
                "Content of TaskDto");
        List<TaskDto>listTaskDto = new LinkedList<>();
        listTaskDto.add(taskDto);


        when(service.getAllTasks()).thenReturn(listTask);
        when(taskMapper.mapToTaskDtoList(ArgumentMatchers.anyList())).thenReturn(listTaskDto);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))//or isOk()
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].title",is("TaskDto")))
                .andExpect(jsonPath("$[0].content",is("Content of TaskDto")));
    }

    @Test
    public void createTask() throws Exception {
        //Given


        Task task =new Task(
                1L,
                "Task",
                "Content of Task");

        TaskDto taskDto =new TaskDto(
                1L,
                "TaskDto",
                "Content of TaskDto");

        when(service.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);
        when(taskMapper.maptotask(ArgumentMatchers.any(TaskDto.class))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));

    }
    @Test
    public void deleteTask() throws Exception {
        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask?taskId=1"))
                .andExpect(status().is(200));
    }
    @Test
    public void updateTask() throws Exception {
        //Given
        Task task =new Task(
                1L,
                "Task",
                "Content of Task");

        TaskDto taskDto =new TaskDto(
                1L,
                "TaskDto",
                "Content of TaskDto");

        when(taskMapper.maptotaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
        when(service.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.title",is("Task")))
                .andExpect(jsonPath("$.content",is("Content of Task")));
    }


}

