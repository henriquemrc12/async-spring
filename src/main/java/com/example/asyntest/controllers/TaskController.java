package com.example.asyntest.controllers;

import com.example.asyntest.enums.TaskStatus;
import com.example.asyntest.forms.TaskFormCreate;
import com.example.asyntest.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskFormCreate form) {
        TaskStatus.validate(form.getStatus());
        service.create(form);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public CompletableFuture<ResponseEntity<?>> findAll() {
        return service.findAll().thenApply(ResponseEntity::ok);
    }

    @GetMapping("/pageable")
    @ResponseBody
    public CompletableFuture<ResponseEntity<?>> findAllPageable(
            @RequestParam(
                    name = "quantity",
                    required = false,
                    defaultValue = "10"
            ) int quantity,
            @RequestParam(
                    name = "page",
                    required = false,
                    defaultValue = "0"
            ) int page
    ) {
        return service.findAllPageable(quantity, page).thenApply(ResponseEntity::ok);
    }
}
