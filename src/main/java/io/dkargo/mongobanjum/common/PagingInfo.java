package io.dkargo.mongobanjum.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PagingInfo {

    private Integer totalPages;

    private Long totalElements;

    private Integer pageSize;

    private Integer pageNumber;

    private Boolean isFirst;

    private Boolean isLast;

    private Boolean hasNext;

    private Boolean hasPrevious;

    private Boolean isEmpty;

    public void changeTotalElements(Long count) {
        this.totalElements = count;
    }
}
