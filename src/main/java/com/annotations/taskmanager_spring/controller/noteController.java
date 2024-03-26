package com.annotations.taskmanager_spring.controller;

import com.annotations.taskmanager_spring.entities.noteEntity;
import com.annotations.taskmanager_spring.service.noteService;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.noteDTO;
import com.annotations.taskmanager_spring.taskDTO.taskDTO.noteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class noteController {
    private noteService noteService;
    public noteController(noteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<noteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
        var notes=noteService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }
    @PostMapping("")
    public ResponseEntity<noteResponseDTO> addNote(@PathVariable("taskId") Integer taskId, @RequestBody noteDTO body){
        var note=noteService.addNoteForTask(taskId,body.getTitle(),body.getBody());
        return ResponseEntity.ok(new noteResponseDTO(taskId, note));
    }
}
