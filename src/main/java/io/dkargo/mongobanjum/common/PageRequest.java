package io.dkargo.mongobanjum.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
public class PageRequest {

    private int page = 1;
    private int size = 50;
    private String[] sortColumns = {"None Sorted"};
    private Sort.Direction direction = Sort.Direction.DESC;

    public PageRequest(int page, int size) {
        this.page = page <= 0 ? 50 : page;

        int MAX_SIZE = 1000;
        this.size = Math.min(size, MAX_SIZE);

        this.direction = Sort.Direction.DESC;
    }

    public PageRequest(int page, int size, Sort.Direction direction) {
        this.page = page <= 0 ? 50 : page;

        int MAX_SIZE = 1000;
        this.size = Math.min(size, MAX_SIZE);

        this.direction = direction;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, this.sortColumns);
    }

    public org.springframework.data.domain.PageRequest of(String sortColumn) {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, sortColumn);
    }

    public org.springframework.data.domain.PageRequest of(String[] sortColumns) {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, sortColumns);
    }
}
