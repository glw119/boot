package com.guoliangwu.boot.mapper;

import com.guoliangwu.boot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author liangwu
 * @Date 18-11-2 上午10:56
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user (first_name, last_name, age, gender) VALUES (#{firstName},#{lastName},#{age},#{gender})")
    @Options(keyColumn = "id", useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);
}
