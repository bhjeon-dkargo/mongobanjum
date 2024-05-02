package io.dkargo.mongobanjum.domain.repository.custom.impl;

import io.dkargo.mongobanjum.common.Paging;
import io.dkargo.mongobanjum.domain.repository.custom.UserRepositoryCustom;
import io.dkargo.mongobanjum.dto.req.ReqUpdateUserDTO;
import io.dkargo.mongobanjum.dto.res.ResAggregationTestDTO;
import io.dkargo.mongobanjum.dto.res.ResGetUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public Paging<ResGetUserDTO> getUserList(PageRequest pageRequest) {

        log.info("pageSize : {}", pageRequest.getPageSize());
        log.info("pageNumber : {}", pageRequest.getPageNumber());

        Query query = new Query()
//                .addCriteria(Criteria.where("name").is("전병훈"))
                .with(pageRequest)
                // 한 페이지에서 보여줄 element 수 * 페이지 번호 = 생략 할 element
                .skip((long) pageRequest.getPageSize() * pageRequest.getPageNumber())
                // 한 페이지에서 보여줄 element 수
                .limit(pageRequest.getPageSize());

        List<ResGetUserDTO> resGetUserDTOList = mongoTemplate.find(query, ResGetUserDTO.class, "users");

        Query queryByTotalElements = new Query();
//                .addCriteria(Criteria.where("name").is("전병훈"));
        long totalElements = mongoTemplate.count(queryByTotalElements, "users");

        return new Paging<>(resGetUserDTOList, totalElements, pageRequest);
    }

    @Override
    @Transactional
    public void updateUserNameById(String userId, ReqUpdateUserDTO reqUpdateUserDTO) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userId));

        Update update = new Update();
        update.set("name", reqUpdateUserDTO.getName());

        // 첫번째 아이만 업데이트
        mongoTemplate.updateFirst(query, update, "users");
    }

    @Override
    public List<ResAggregationTestDTO> getAggregationTest() {

        MatchOperation matchOperation = Aggregation.match(new Criteria().andOperator(Criteria.where("name").ne(null)));

        // .addToSet("name").as("name"); 해당 코드를 추가안해주면, ResDTO에서 name이 아닌 _id로 해놔야 이름이 매칭이 된다.
        GroupOperation groupOperation = Aggregation.group("name").count().as("count").addToSet("name").as("name");

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupOperation);

        AggregationResults<ResAggregationTestDTO> results = mongoTemplate.aggregate(aggregation, "users", ResAggregationTestDTO.class);

        log.info("results : {}", results.getMappedResults());

        return results.getMappedResults();
    }
}
