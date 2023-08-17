package com.iyang.controller;

import com.github.javafaker.Faker;
import com.iyang.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/****
 * author: BaoYang
 * date: 2023/8/16
 * desc:
 ***/


@RequestMapping(value = "/v1")
@RestController
public class UserInfoController {

    @GetMapping(value = "/user/list")
    public List<UserInfo> userList(@RequestParam(defaultValue = "10") Integer counts){

        List<UserInfo> userInfoList = IntStream.range(0, counts).mapToObj(v -> {
            Faker faker = new Faker();
            UserInfo build = UserInfo.builder()
                    .userId(faker.number().randomNumber())
                    .userName(faker.name().lastName())
                    .age(faker.number().randomNumber())
                    .phone(faker.phoneNumber().phoneNumber())
                    .hobby(faker.app().name()).build();
            return build;
        }).collect(Collectors.toList());
        return userInfoList;
    }

}
