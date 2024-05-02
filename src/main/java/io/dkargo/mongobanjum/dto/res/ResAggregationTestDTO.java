package io.dkargo.mongobanjum.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResAggregationTestDTO {

    private String name;

    private long count;
}
