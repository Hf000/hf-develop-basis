package com.hufei.mts;

import com.hufei.mts.mapper.UserMapper;
import com.hufei.mts.pojo.po.User;
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
 * @date 2021/2/21 21:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        User user = this.userMapper.getById(1L);
        System.out.println(user);
    }

}
