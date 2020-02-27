package com.strutnut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class MyTest {

    @Test
    public void test()
    {
        Logger logger = LogManager.getLogger(MyTest.class);
       logger.info("info");
       logger.debug("debug");
       logger.warn("warn");
       logger.error("error");

    }
}
