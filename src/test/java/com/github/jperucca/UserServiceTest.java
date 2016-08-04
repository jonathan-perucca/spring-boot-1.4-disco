package com.github.jperucca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void should_work_without_autowired_over_constructor() {
        assertThat(userService.getUserRepository()).isNotNull();
    }
}
