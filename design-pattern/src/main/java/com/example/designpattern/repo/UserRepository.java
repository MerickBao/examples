package com.example.designpattern.repo;

import com.example.designpattern.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/14 21:50
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    // 根据用户名查找用户
    UserInfo findByUserName(String userName);

    // 根据用户名和密码查找用户
    UserInfo findByUserNameAndUserPassword(String account, String password);
}
