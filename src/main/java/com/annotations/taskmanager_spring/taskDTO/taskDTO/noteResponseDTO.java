package com.annotations.taskmanager_spring.taskDTO.taskDTO;

import com.annotations.taskmanager_spring.entities.noteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class noteResponseDTO {
    private int taskId;
    private noteEntity note;
}
