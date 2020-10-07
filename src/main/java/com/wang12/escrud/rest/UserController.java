package com.wang12.escrud.rest;

import com.wang12.escrud.domain.User;
import com.wang12.escrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
class UserController
{

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test()
    {


        ArrayList<User> uer_list = new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            User u = new User();
            u.setId(i);
            u.setAge(i);
            u.setName(i+"test title name");
            u.setDes(i+"test desc");
            uer_list.add(u);
        }
        userService.saveAll(uer_list);
        return "ok";
    }

    @GetMapping("/all")
    public Iterator<User> all(){
        return userService.findAll();
    }
    @GetMapping("/q")
    public Page<User> q(@RequestParam String k){
        return userService.query(k);
    }
    @GetMapping("/r")
    public User f(@RequestParam Long id){
        return userService.read(id);

    }
    @GetMapping("/d")
    public String d(@RequestParam Long id){
         userService.del(id);
         return "ok";

    }
}