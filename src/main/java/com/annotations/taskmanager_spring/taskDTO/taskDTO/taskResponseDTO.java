package com.annotations.taskmanager_spring.taskDTO.taskDTO;

import com.annotations.taskmanager_spring.entities.noteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class taskResponseDTO {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private Boolean completed;
    private List<noteEntity> note;
}
