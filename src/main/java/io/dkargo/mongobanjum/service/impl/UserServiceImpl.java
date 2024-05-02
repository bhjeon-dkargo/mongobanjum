package io.dkargo.mongobanjum.service.impl;

import io.dkargo.mongobanjum.common.ResListDTO;
import io.dkargo.mongobanjum.domain.entity.User;
import io.dkargo.mongobanjum.domain.repository.UserRepository;
import io.dkargo.mongobanjum.dto.req.ReqCreateUserDTO;
import io.dkargo.mongobanjum.dto.req.ReqUpdateUserDTO;
import io.dkargo.mongobanjum.dto.res.ResAggregationTestDTO;
import io.dkargo.mongobanjum.dto.res.ResGetUserDTO;
import io.dkargo.mongobanjum.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResGetUserDTO createUser(ReqCreateUserDTO reqCreateUserDTO) {

        User.UserDetail userDetail = User.UserDetail.builder()
                .allAssets(reqCreateUserDTO.getAllAssets())
                .build();

        User user = userRepository.save(User.builder()
                .name(reqCreateUserDTO.getName())
                .age(reqCreateUserDTO.getAge())
                .userDetail(userDetail)
                .build());

        // transactional 확인
        if (reqCreateUserDTO.getName().equals("신미경")) {
            throw new RuntimeException();
        }

        return ResGetUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    @Override
    public ResGetUserDTO getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(RuntimeException::new);

        // 뎁스가 하나 더있으면, null 체크 확인
//        ResGetUserDTO.UserDetail userDetail = ResGetUserDTO.UserDetail.builder()
//                .allAssets(user.getUserDetail().getAllAssets())
//                .build();

        return ResGetUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
//                .userDetail(userDetail)
                .build();
    }

    @Override
    public ResListDTO<ResGetUserDTO> getUserList(PageRequest pageRequest) {

        return new ResListDTO<>(userRepository.getUserList(pageRequest));
    }

    @Override
    @Transactional
    public void updateUserNameById(String userId, ReqUpdateUserDTO reqUpdateUserDTO) {
        userRepository.updateUserNameById(userId, reqUpdateUserDTO);
    }

    @Override
    @Transactional
    public void deleteUserById(String userId) {

        userRepository.deleteById(userId);
    }

    @Override
    public List<ResAggregationTestDTO> getAggregationTest() {

        return userRepository.getAggregationTest();
    }
}
