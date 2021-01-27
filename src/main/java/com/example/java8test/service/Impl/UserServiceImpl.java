package com.example.java8test.service.Impl;

import com.example.java8test.dao.UserRepository;
import com.example.java8test.entity.User;
import com.example.java8test.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author XiangYanLin
 * @date 2021/1/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveWithException(User user){
        userRepository.save(user);
        throw new RuntimeException("测试事务传播性！");
    }

    @Override
    public void testPropagation1(){
        User user1=new User();
        user1.setUserName("张三");
        save(user1);

        User user2=new User();
        user2.setUserName("李四");
        save(user2);
        throw new RuntimeException();
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void testPropagation2() {
        User user1=new User();
        user1.setUserName("张三");
        save(user1);

        User user2=new User();
        user2.setUserName("李四");
        saveWithException(user2);
    }
}
