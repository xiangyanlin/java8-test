package com.example.java8test.controller;

import com.example.java8test.entity.Apple;
import com.example.java8test.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author XiangYanLin.
 * @Date Created in 9:37 2020/11/19
 * @Description：
 */
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @PostMapping("/hello")
    public String test(String name,@RequestBody List<Apple> list) {
        /**
         * 接收List的条件
         * 1、使用JSON格式数据，如[{"a":"a","b":"b"}] 放在RequestBody中传递
         * 2、RequestHeader中需要有 Content-Type: application/json;charset=utf8
         * 3、需要在参数前加上@RequestBody
         */

        System.out.println(list.get(0).getWeight());
        return list.size()+":"+name;
    }

    @PostMapping("/hi")
    public String hi(@RequestParam("list") List<String> list) {
        /**
         * 接收List<String>
         * 1、Request Parameters中list=a,b,c
         * 2、必须写上@RequestParam("list")
         */
        System.out.println(list.get(0));
        return list.size()+"";
    }

    @PostMapping("/hey")
    public String hey( String[] list,@RequestParam("abc")String abc) {
        /**
         * 接收数组
         * 1、Request Parameters中list=a,b,c 即可成功接收
         */
        System.out.println(list[0].toString());
        System.out.println(list[1].toString());
        return list.length+"";
    }


    @RequestMapping("/test1")
    public void test1(){
        userService.testPropagation1();
    }

    @RequestMapping("/test2")
    public void test2(){
        userService.testPropagation2();
    }

}
