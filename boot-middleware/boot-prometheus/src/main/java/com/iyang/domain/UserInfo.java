package com.iyang.domain;

import lombok.*;

/****
 * author: BaoYang
 * date: 2023/8/16
 * desc:
 ***/


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserInfo {

    private Long userId;
    private String userName;
    private Long age;
    private String phone;
    private String hobby;

}
