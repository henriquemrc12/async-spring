package com.example.asyntest.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskFormCreate {

    private String name;

    private String description;

    private String status;

    private LocalDate endDate;
}
