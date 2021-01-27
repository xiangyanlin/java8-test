package com.example.java8test.service;

import com.example.java8test.entity.User;

/**
 * @author XiangYanLin
 * @date 2021/1/27
 */
public interface UserService {
    /**
     * 保存
     * @param user
     */
    void save(User user);


    /**
     * 保存 RuntimeException
     * @param user
     */
    void saveWithException(User user);

    /**
     * 验证方法1
     */
    void testPropagation1();

    /**
     * 验证方法2
     */
    void testPropagation2();
}
