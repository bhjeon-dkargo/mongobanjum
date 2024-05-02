package io.dkargo.mongobanjum.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqCreateUserDTO {

    private String name;

    private Integer age;

    private Float weight;

    private Float height;

    private Float allAssets;
}
