package io.dkargo.mongobanjum.domain.repository.custom;

import io.dkargo.mongobanjum.common.Paging;
import io.dkargo.mongobanjum.dto.req.ReqUpdateUserDTO;
import io.dkargo.mongobanjum.dto.res.ResAggregationTestDTO;
import io.dkargo.mongobanjum.dto.res.ResGetUserDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserRepositoryCustom {

    Paging<ResGetUserDTO> getUserList(PageRequest pageRequest);

    void updateUserNameById(String userId, ReqUpdateUserDTO reqUpdateUserDTO);

    List<ResAggregationTestDTO> getAggregationTest();
}
