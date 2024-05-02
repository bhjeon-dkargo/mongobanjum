package io.dkargo.mongobanjum.controller;

import io.dkargo.mongobanjum.common.PageRequest;
import io.dkargo.mongobanjum.common.ResListDTO;
import io.dkargo.mongobanjum.dto.req.ReqCreateUserDTO;
import io.dkargo.mongobanjum.dto.req.ReqUpdateUserDTO;
import io.dkargo.mongobanjum.dto.res.ResAggregationTestDTO;
import io.dkargo.mongobanjum.dto.res.ResGetUserDTO;
import io.dkargo.mongobanjum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    // [CREATE]
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResGetUserDTO createUser(@RequestBody ReqCreateUserDTO createUserDTO) {

        return userService.createUser(createUserDTO);
    }

    // [READ by ONE]
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetUserDTO getUserById(@PathVariable("userId") String userId) {

        return userService.getUserById(userId);
    }

    // [READ by MANY]
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResListDTO<ResGetUserDTO> getUserList(final PageRequest pageRequest) {

        return userService.getUserList(pageRequest.of());
    }

    // [UPDATE - PATCH]
    @PatchMapping("/{userId}/name")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserNameById(@PathVariable("userId") String userId,
                                   @RequestBody ReqUpdateUserDTO reqUpdateUserDTO) {
        userService.updateUserNameById(userId, reqUpdateUserDTO);
    }

    // [DELETE]
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable("userId") String userId) {

        userService.deleteUserById(userId);
    }

    // [READ By Aggregation Test]
    @GetMapping("/aggregation-test")
    @ResponseStatus(HttpStatus.OK)
    public List<ResAggregationTestDTO> getAggregationTest() {
        return userService.getAggregationTest();
    }

}
