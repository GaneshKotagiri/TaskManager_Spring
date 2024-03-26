package com.annotations.taskmanager_spring.entities;

import lombok.Data;

@Data
public class noteEntity {
    private int noteId;
    private String title;
    private String body;
}
