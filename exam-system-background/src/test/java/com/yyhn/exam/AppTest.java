package com.yyhn.exam;

import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.mapper.SysRoleMapper;
import com.yyhn.exam.service.SysRoleService;
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
    SysRoleMapper sysRoleMapper;
    @Test
    public void test01(){
        List<SysRole> roles =  sysRoleMapper.getUserRolesByUserId(Integer.valueOf(1));
        System.out.println(roles.get(0).getRoleName());
    }
}
