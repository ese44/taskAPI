package com.clara.taskdb.controller;

import com.clara.taskdb.model.Task;
import com.clara.taskdb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by by9506zi on 4/12/2018.
 */

@RestController
public class TaskAPIController {

    private final TaskRepository tasks;

    @Autowired
    public TaskAPIController(TaskRepository tasks){
        this.tasks = tasks;

        tasks.save(new Task("task 1", true, false));

    }

    @PostMapping(value="/add")
    public ResponseEntity addTask(@RequestBody Task task){
        System.out.println("new task: " + task);
        try{
            tasks.save(task);
        } catch (Exception e){
            return new ResponseEntity<>("Task object is invalid", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> queryTasks(){
        return new ResponseEntity<>(tasks.findAllByOrderByUrgentDesc(), HttpStatus.OK);
    }
}
