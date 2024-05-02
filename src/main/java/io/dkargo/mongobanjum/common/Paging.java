package io.dkargo.mongobanjum.common;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class Paging<CONTENT_TYPE> extends PageImpl<CONTENT_TYPE> {
    public Paging(List<CONTENT_TYPE> content, long totalCount, Pageable pageable) {
        super(content, pageable, totalCount);
    }

    public List<CONTENT_TYPE> getContent() {
        return super.getContent();
    }

    public PagingInfo getPagingInfo() {
        return PagingInfo.builder()
                .totalPages(super.getTotalPages())
                .totalElements(super.getTotalElements())
                .pageSize(super.getSize())
                .pageNumber(super.getNumber() + 1)
                .isFirst(super.isFirst())
                .isLast(super.isLast())
                .hasNext(super.hasNext())
                .hasPrevious(super.hasPrevious())
                .isEmpty(super.isEmpty())
                .build();
    }
}

