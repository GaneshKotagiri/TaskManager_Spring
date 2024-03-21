package com.annotations.taskmanager_spring.service;
import com.annotations.taskmanager_spring.entities.taskEntities;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private ArrayList<taskEntities> tasks=new ArrayList<>();
    @Getter
    private int taskId = 1;
   public taskEntities addTask(String title, String description, String deadline){
        taskEntities task=new taskEntities();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        //task.setDeadline(new Date(deadline));
        tasks.add(task);
        taskId++;
        return task;
    }
    public ArrayList<taskEntities> getTasks(){
        return tasks;
    }

    public taskEntities getTaskById(int id){
        for(taskEntities task:tasks){
            if(task.getId()==id){
                return task;
            }
        }
        return null;
    }


}