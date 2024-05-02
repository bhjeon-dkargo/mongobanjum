package io.dkargo.mongobanjum.service;

import io.dkargo.mongobanjum.common.ResListDTO;
import io.dkargo.mongobanjum.dto.req.ReqCreateUserDTO;
import io.dkargo.mongobanjum.dto.req.ReqUpdateUserDTO;
import io.dkargo.mongobanjum.dto.res.ResAggregationTestDTO;
import io.dkargo.mongobanjum.dto.res.ResGetUserDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {

    ResGetUserDTO createUser(ReqCreateUserDTO reqCreateUserDTO);

    ResGetUserDTO getUserById(String userId);

    ResListDTO<ResGetUserDTO> getUserList(PageRequest pageRequest);

    void updateUserNameById(String userId, ReqUpdateUserDTO reqUpdateUserDTO);

    void deleteUserById(String userId);

    List<ResAggregationTestDTO> getAggregationTest();

}
