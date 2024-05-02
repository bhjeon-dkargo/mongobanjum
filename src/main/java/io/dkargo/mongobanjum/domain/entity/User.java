package io.dkargo.mongobanjum.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

// @DynamicUpdate
// MongoDB 스키마가 유연하고 동적이므로 특정 문서의 필드를 업데이트하더라도 다른 필드에 영향을 미치지 않는다.
// 필요한 경우 문서의 일부 필드만 업데이트하여 나머지 필드는 변경되지 않도록 제어할 수 있다.
// -> MongoDB는 이러한 동적인 업데이트를 자동으로 처리한다.

@Document(collection = "users")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @Field(value = "_id", targetType = FieldType.OBJECT_ID)
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
