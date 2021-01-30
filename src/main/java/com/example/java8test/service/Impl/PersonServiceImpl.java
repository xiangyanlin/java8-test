package com.example.java8test.service.Impl;

import com.example.java8test.dao.PersonRepository;
import com.example.java8test.entity.Person;
import com.example.java8test.entity.User;
import com.example.java8test.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author XiangYanLin
 * @date 2021/1/27
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonRepository personRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void save(Person person){
        personRepository.save(person);
    }
}
