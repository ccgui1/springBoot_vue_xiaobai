package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  extends ServiceImpl<UserMapper, User> {

    public  boolean saveUser(User user){
        if(user.getId() == null){
            save(user);
        }else{
            updateById(user);
        }
        return  true;
    }



//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user){
//        if(user.getId() == null){
//          return   userMapper.insertUser(user);
//        }else {
//          return   userMapper.update(user);
//        }
//    }
}
