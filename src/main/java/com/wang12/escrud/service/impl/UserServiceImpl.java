package com.wang12.escrud.service.impl;

import com.wang12.escrud.domain.User;
import com.wang12.escrud.repository.UserRepository;
import com.wang12.escrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Pageable pageable = PageRequest.of(0,10);
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveAll(List<User> list) {
        userRepository.saveAll(list);
    }

    @Override
    public Iterator<User> findAll() {
        return userRepository.findAll().iterator();
    }

    @Override
    public Page<User> query(String key) {
        return userRepository.query(key,pageable);
    }

    @Override
    public User read(Long id) {
        Optional<User> u = userRepository.findById(id);
        return u.isPresent() ? u.get() : new User();
    }

    @Override
    public void del(Long id) {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()){
            userRepository.delete(u.get());
        }
    }


}
