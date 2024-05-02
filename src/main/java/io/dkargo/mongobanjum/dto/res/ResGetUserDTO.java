package io.dkargo.mongobanjum.dto.res;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResGetUserDTO {

    private String id;

    private String name;

    private Integer age;

    private UserDetail userDetail;

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class UserDetail {

        private Float allAssets;
    }
}
