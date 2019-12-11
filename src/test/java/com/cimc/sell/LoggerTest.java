package com.cimc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1(){
        log.info("1111111111111");
    }

    @Test
    public void test2(){
        log.info("222222222222");
    }
}
