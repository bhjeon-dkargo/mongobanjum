package io.dkargo.mongobanjum.domain.repository;

import io.dkargo.mongobanjum.domain.entity.User;
import io.dkargo.mongobanjum.domain.repository.custom.UserRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {

    void deleteById(String userId);
}
