package com.clara.taskdb.controller;

import com.clara.taskdb.model.Task;
import com.clara.taskdb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by by9506zi on 4/12/2018.
 */

@RestController
public class TaskAPIController { // create Task API controller class

    private final TaskRepository tasks; // TaskRepository variable to hold the tasks

    @Autowired
    public TaskAPIController(TaskRepository tasks){ // TaskAPIController constructor
        this.tasks = tasks;

    }

    @PostMapping(value="/add") // mapping for adding a task
    public ResponseEntity addTask(@RequestBody Task task){
        System.out.println("new task: " + task);
        try{ // exception handling try block
            tasks.save(task);
        } catch (Exception e){ // catch block
            return new ResponseEntity<>("Task object is invalid", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/tasks") // mapping for viewing tasks
    public ResponseEntity<List<Task>> queryTasks(){
        return new ResponseEntity<>(tasks.findAllByOrderByUrgentDesc(), HttpStatus.OK);
    }

    @PatchMapping(value = "/completed") // mapping for completing a task
    public ResponseEntity markTaskAsCompleted(@RequestBody Task task){

        int tasksUpdated = tasks.setTaskCompleted(task.isCompleted(), task.getId());
        if (tasksUpdated == 0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/delete") // mapping for deleting tasks
    public ResponseEntity deleteTask(@RequestBody Task task){
        tasks.delete(task);
        return new ResponseEntity(HttpStatus.OK);
    }
}
