package com.yyhn.exam;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class studentTest {

    @Resource
    StudentMapper studentMapper;


    @Test
    public void test01(){
        List<Student> allStudent = studentMapper.getAllStudent(null);
        for (Student stu:allStudent) {
            System.out.println("stu = " + stu.getStuName());
        }
    }

}
