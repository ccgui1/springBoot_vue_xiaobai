package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Insert("insert into sys_user(username,`password`,nickname,email,phone,address) " +
//            "VALUES(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
//    public Integer insertUser(User user);
//
//
//
//    Integer update(User user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like concat('%',#{username},'%') limit #{pageNum},#{pageSize}")
//    List<User> seletctPage(Integer pageNum, Integer pageSize,String username);
//
//    @Select("select count(id) from sys_user where username like concat('%',#{username},'%')")
//    Integer seletctTotal(String username);
}
