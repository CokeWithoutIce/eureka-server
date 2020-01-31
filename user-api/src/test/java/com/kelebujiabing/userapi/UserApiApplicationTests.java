package com.kelebujiabing.userapi;

import com.alibaba.fastjson.JSON;
import com.kelebujiabing.userapi.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApiApplicationTests {

    @Test
    void contextLoads() {

        String s = JSON.toJSONString(new User());
        System.out.println(s);


    }

}
