package com.example.elasticsearch.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/8/23 22:50
 */

public interface UserRepository extends ElasticsearchRepository<User, String> {

    //List<User> findUserByName(String name);
}
