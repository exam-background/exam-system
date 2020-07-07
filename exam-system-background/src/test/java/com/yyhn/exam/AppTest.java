package com.yyhn.exam;

import static org.junit.Assert.assertTrue;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.ClassMapper;
import com.yyhn.exam.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppTest {


    @Resource
    StudentMapper studentMapper;

    @Resource
    ClassMapper classMapper;

    @Test
    public void test01(){
        System.out.println("classMapper = " + classMapper);
    }
}
