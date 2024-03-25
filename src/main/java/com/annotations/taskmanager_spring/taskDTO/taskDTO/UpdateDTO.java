package com.annotations.taskmanager_spring.taskDTO.taskDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateDTO {
     String description;
     String deadline;
     Boolean completed;
}
