package com.guoliangwu.boot;

import com.guoliangwu.boot.mapper.UserMapper;
import com.guoliangwu.boot.model.User;
import com.guoliangwu.boot.utils.RedisUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void contextLoads() {
//        PageHelper.startPage(0, 0);
//        List<User> userList  = userMapper.findAll();
//        redisUtils.set("userList", userList, RedisUtils.DEFAULT_EXPIRE);
        System.out.println(redisUtils.get("userList", List.class, RedisUtils.DEFAULT_EXPIRE));
    }

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            User user = User.builder().firstName(RandomStringUtils.randomAlphabetic(5))
                    .lastName(RandomStringUtils.randomAlphabetic(10))
                    .age(RandomUtils.nextInt(10,100))
                    .gender(RandomUtils.nextInt(1,5))
                    .build();
            userMapper.saveUser(user);
            System.out.println(user);
        }
    }
}
