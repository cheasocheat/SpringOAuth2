package com.mobiecode.core;

import com.mobiecode.core.util.BaseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void contextLoads() {

    }

    @Test
    public void passwordEncode() {
        System.out.println(encoder.encode("password"));
    }
}
