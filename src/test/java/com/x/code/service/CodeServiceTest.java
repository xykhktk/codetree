package com.x.code.service;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
class CodeServiceTest {

    @Autowired
    private CodeService codeService;

    @Test
    void allList() {
        codeService.codeTree();
    }

    @Test
    void findById() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}