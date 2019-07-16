package com.spring.demo;

import com.spring.demo.redis.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object, Employee> empRedisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testRedisSet(){
        empRedisTemplate.opsForValue().set("emp-02",employeeMapper.getEmpById(1),10000,TimeUnit.MILLISECONDS);
    }
    @Test
    public void testRedisGet(){
        System.out.println(empRedisTemplate.opsForValue().get("emp-02"));
    }
    @Test
    public void testRedisList(){
        stringRedisTemplate.opsForList().leftPush("myList2","first");
        stringRedisTemplate.opsForList().rightPush("myList2","second");
        System.out.println(stringRedisTemplate.opsForList().index("myList2",1));
    }

}
