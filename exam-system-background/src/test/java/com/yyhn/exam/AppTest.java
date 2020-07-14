package com.yyhn.exam;

import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.entity.SysPermission;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.mapper.ClassMapper;
import com.yyhn.exam.mapper.StudentMapper;
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
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppTest {


    @Resource
    StudentMapper studentMapper;

    @Resource
    SysRoleService  sysRoleService;

    @Test
    public void test01(){
//        List<SysRole> roleByList = sysRoleService.getRoleByList();
//        for (SysRole sysRole : roleByList) {
            SysRole sysRole = sysRoleService.getRoleById(1);
            System.out.println("角色名称  =========  权限名称");
            for (SysPermission permission : sysRole.getPermissions()) {
                System.out.println(sysRole.getRoleName()+"-----------"+permission.getPermissionName());
            }
//        }
    }
}
