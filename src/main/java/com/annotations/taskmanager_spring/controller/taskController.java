package com.annotations.taskmanager_spring.controller;

import com.annotations.taskmanager_spring.entities.taskEntities;
import com.annotations.taskmanager_spring.service.taskService;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/tasks")
public class taskController {
    public final taskService taskService;

    public taskController(taskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("")
    public ResponseEntity<List<taskEntities>> getTasks(){
        var tasks= taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<taskEntities> getTaskById(@PathVariable("id") Integer id){
        var task=taskService.getTaskById(id);
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);

    }@PostMapping("")
    public ResponseEntity<taskEntities> addTask(@RequestBody task body){
        var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }
}

