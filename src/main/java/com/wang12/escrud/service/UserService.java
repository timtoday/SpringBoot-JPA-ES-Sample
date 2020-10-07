package com.wang12.escrud.service;

import com.wang12.escrud.domain.User;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveAll(List<User> list);

    Iterator<User> findAll();

    Page<User> query(String key);

    User read(Long id);


    void del(Long id);

}
