package com.example.asyntest.enums;

public enum TaskStatus {

    TO_DO("TO DO"),
    DOING("DOING"),
    DONE("DONE");

    private String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public static void validate(String description) {
        try {
            for(TaskStatus taskStatus : TaskStatus.values()){
                if(taskStatus.name().equalsIgnoreCase(description.trim()))
                    return;
                throw new IllegalArgumentException("Status de Task inválida!");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
