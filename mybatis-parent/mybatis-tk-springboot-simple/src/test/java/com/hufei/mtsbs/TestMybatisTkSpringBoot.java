package com.hufei.mtsbs;

import com.hufei.mtsbs.mapper.UserMapper;
import com.hufei.mtsbs.pojo.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/2/21 22:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisTkSpringBoot {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = this.userMapper.selectAll();
        users.forEach(user -> System.out.println(user));
    }

}
