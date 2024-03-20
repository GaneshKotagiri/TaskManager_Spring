package com.annotations.taskmanager_spring.taskDTO.taskDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
public class task {
    String title;
    String description;
    String deadline;
}
