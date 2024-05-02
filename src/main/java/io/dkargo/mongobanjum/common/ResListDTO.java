package io.dkargo.mongobanjum.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResListDTO<CONTENT_TYPE> {

    private List<CONTENT_TYPE> data;

    private PagingInfo pagingInfo;

    public ResListDTO(Paging<CONTENT_TYPE> paging) {
        this.data = paging.getContent();
        this.pagingInfo = paging.getPagingInfo();
    }
}
