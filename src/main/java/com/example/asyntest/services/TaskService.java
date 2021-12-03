package com.example.asyntest.services;

import com.example.asyntest.dtos.DtoPaginator;
import com.example.asyntest.entities.TaskEntity;
import com.example.asyntest.enums.TaskStatus;
import com.example.asyntest.forms.TaskFormCreate;
import com.example.asyntest.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Async
    public void create(TaskFormCreate form){
        try {
            TaskEntity newTask = new TaskEntity();
            newTask.setName(form.getName().trim());
            newTask.setDescription(
                    form.getDescription() != null ?
                    form.getDescription().trim() : "");
            newTask.setStatus(TaskStatus.valueOf(form.getStatus().trim().toUpperCase()));
            newTask.setEndDate(form.getEndDate());
            repository.save(newTask);
            return;
        } catch (Exception e) {
            throw e;
        }
    }

    public CompletableFuture<List<TaskEntity>> findAll(){
        try {
            List<TaskEntity> listFounded = repository.findAll();
            return CompletableFuture.completedFuture(listFounded);
        } catch (Exception e) {
            throw e;
        }
    }

    public CompletableFuture<DtoPaginator> findAllPageable(int quantity, int page){
        try {
            Pageable sort = PageRequest.of(page, quantity, Sort.unsorted());
            Page<TaskEntity> listFounded = repository
                    .findAll(sort);
            DtoPaginator dtoPaginator = new DtoPaginator(
                    listFounded.getTotalPages(),
                    listFounded.getSize(),
                    listFounded.getTotalElements(),
                    listFounded.getContent()
            );
            return CompletableFuture.completedFuture(dtoPaginator);
        } catch (Exception e) {
            throw e;
        }
    }
}
