package com.example.asyntest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoPaginator {
    private int totalPages;

    private int size;

    private long totalElements;

    private List<?> content;
}
