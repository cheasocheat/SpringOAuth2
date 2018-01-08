package com.mobiecode.core;

import com.mobiecode.core.util.BaseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void passwordEncode() {
        System.out.println(BaseUtil.getInstance().getPasswordEncoder().encode("password"));
    }
}
