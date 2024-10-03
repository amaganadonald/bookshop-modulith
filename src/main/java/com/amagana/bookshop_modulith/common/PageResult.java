package com.amagana.bookshop_modulith.common;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResult<T>(List<T> data, long totalElements, int pageNumber, int totalPages, boolean isFirst,
                            boolean isLast, boolean hasNext, boolean hasPrevious) {

    public PageResult(Page<T> page) {
        this(
                page.getContent(),
                page.getTotalElements(),
                page.getNumber()+1,
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious()
        );
    }
}

