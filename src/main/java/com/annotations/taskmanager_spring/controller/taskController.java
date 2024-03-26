package com.annotations.taskmanager_spring.controller;

import com.annotations.taskmanager_spring.entities.taskEntities;
import com.annotations.taskmanager_spring.service.TaskService;
import com.annotations.taskmanager_spring.service.noteService;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.ErrorResponseDTO;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.UpdateDTO;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.task;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.taskResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping (value = "/tasks")
public class taskController {
    private final TaskService taskService;
    private final noteService noteService;
    private final ModelMapper modelMapper=new ModelMapper();


    public taskController(TaskService taskService,noteService noteService) {
        this.taskService = taskService;
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<taskEntities>> getTasks(){
        var tasks= taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<taskResponseDTO> getTaskById(@PathVariable("id") Integer id){
        var task=taskService.getTaskById(id);
        var notes=noteService.getNotesForTask(id);
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        var taskResponse=modelMapper.map(task, taskResponseDTO.class);
        taskResponse.setNote(notes);
        return ResponseEntity.ok(taskResponse);
    }@PostMapping("")
    public ResponseEntity<taskEntities> addTask(@RequestBody task body) throws ParseException {
        var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<taskEntities> update(@PathVariable("id") Integer id, @RequestBody UpdateDTO body) throws ParseException {
        var task=taskService.update(id,body.getDescription(),body.getDeadline(),body.getCompleted());
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e){
        if( e instanceof ParseException){
            ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid  date format"));
        }
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal server error"));
    }
}

