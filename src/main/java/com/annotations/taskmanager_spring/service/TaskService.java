package com.annotations.taskmanager_spring.service;
import com.annotations.taskmanager_spring.entities.taskEntities;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<taskEntities> tasks=new ArrayList<>();
    @Getter
    private int taskId = 1;
    private SimpleDateFormat deadlineFormatter=new SimpleDateFormat("MM-DD-YYY");
   public taskEntities addTask(String title, String description, String deadline) throws ParseException {
        taskEntities task=new taskEntities();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        task.setDeadline(deadlineFormatter.parse(deadline));
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
    public taskEntities update(int id, String description,String deadline, Boolean completed) throws ParseException {
       taskEntities task=getTaskById(id);
       if(task==null){
           return null;
       }
       if (description != null) {
           task.setDescription(description);
       }
       if(completed!=null){
           task.setCompleted(completed);
       }
       if(deadline!=null){
           task.setDeadline(deadlineFormatter.parse(deadline));
       }
       return task;
    }
}