package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> index(){
        return  userService.list();
    }

    @PostMapping()
    public  boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }


    // 根据id删除
    @DeleteMapping("/{id}")
    public  boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

//   @GetMapping("/page")
//    public  Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                         @RequestParam Integer pageSize,
//                                         @RequestParam String  username){
//        pageNum = (pageNum-1)*pageSize;
//
//        Integer total= userMapper.seletctTotal(username);
//
//        List<User> data =  userMapper.seletctPage(pageNum,pageSize,username);
//
//       Map<String,Object> res = new HashMap<>();
//       res.put("data",data);
//       res.put("total",total);
//       return  res;
//
//   }

    // 分页查询，mybatis-plus实现
    @GetMapping("/page")
    public IPage<User>  findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String username,
                                 @RequestParam(defaultValue = "") String email,
                                 @RequestParam(defaultValue = "") String address){
        // IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(!Strings.isEmpty(username),"username",username);
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }

        queryWrapper.orderByDesc("id");

        return userService.page(page,queryWrapper);
    }

    @PostMapping("/del/batch")
    public boolean delAll(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }
}
