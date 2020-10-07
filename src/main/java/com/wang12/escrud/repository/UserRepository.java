package com.wang12.escrud.repository;

import com.wang12.escrud.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface UserRepository extends ElasticsearchRepository<User, Long> {


    @Query("{\"bool\" : {\"must\" : {\"term\":{\"id\":\"?\"}}}}")
    Page<User> query(String key, Pageable pageable);
}