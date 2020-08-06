package com.yyhn.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppTest {
    @Test
    public void test01(){
        int a = 50;
        int b = 5;
        if(a%b != 0){
            System.out.println((a/b)+":"+((a/b)+a%b));
        }else{
            System.out.println(a/b);
        }
    }
}
