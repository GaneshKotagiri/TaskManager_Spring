package com.annotations.taskmanager_spring.entities;
import lombok.Data;

import java.util.Date;
@Data
public class taskEntities {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private Boolean completed;
}
