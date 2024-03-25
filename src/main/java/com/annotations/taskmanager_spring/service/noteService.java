package com.annotations.taskmanager_spring.service;

import com.annotations.taskmanager_spring.entities.noteEntity;
import com.annotations.taskmanager_spring.entities.taskEntities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class noteService {
    TaskService taskService;
    private HashMap<Integer, taskNotesHolder> taskNoteHolders=new HashMap<>();
    public noteService(TaskService taskService) {
        this.taskService = taskService;
    }
    class taskNotesHolder{
        private int noteId=1;
        ArrayList<noteEntity> notes=new ArrayList<>();
    }
    public List<noteEntity> getNotesForTask(int taskId){
        taskEntities task=taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNoteHolders.get(taskId)==null){
            taskNoteHolders.put(taskId,new taskNotesHolder());
        }
        return taskNoteHolders.get(taskId).notes;
    }
}
