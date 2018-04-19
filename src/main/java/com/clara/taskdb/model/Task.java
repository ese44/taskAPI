package com.clara.taskdb.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by by9506zi on 4/12/2018.
 */

@Entity
public class Task { // create the Task class

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // create id variable

    @Column(nullable = false)
    @Size(min = 1)
    private String text; // text variable

    private boolean urgent; // boolean if the task is urgent
    private boolean completed = false; // boolean if the task has been completed

    public Task(){} // empty Task object constructor

    public Task(@Size(min = 1) String text, boolean urgent, boolean completed) { // Task object constructor with data
        this.text = text;
        this.urgent = urgent;
        this.completed = completed;
    }

    // setters and getters for the Task object data
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
