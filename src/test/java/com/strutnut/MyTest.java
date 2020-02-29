package com.strutnut;

import com.strutnut.config.SpringConfig;
import com.strutnut.utils.TokenUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//测试环境
@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Autowired
    TokenUtils tokenUtils;

    @Test
    public void test() {
        Logger logger = LogManager.getLogger(MyTest.class);
        System.out.println(tokenUtils.expiration);

    }
}
