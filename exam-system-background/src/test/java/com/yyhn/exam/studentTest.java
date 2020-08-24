package com.yyhn.exam;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.mapper.StudentMapper;
import com.yyhn.exam.mapper.SysRoleMapper;
import com.yyhn.exam.service.SysUserService;
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

    @Resource
    SysRoleMapper sysRoleMapper;

    @Resource
    SysUserService sysUserService;


    @Test
    public void test01(){
        List<Student> allStudent = studentMapper.getAllStudent(null);
        for (Student stu:allStudent) {
            System.out.println("stu = " + stu.getStuName());
        }
    }
    @Test
    public void test02(){
        List<SysRole> roleList = sysRoleMapper.selectList(null);
        for (SysRole role : roleList) {
            System.out.println("role.getRoleName() = " + role.getRoleName());
        }
    }

    @Test
    public void test03(){
        List<SysUser> sysUserList = sysUserService.getSysUserByPage(null, null, 1, 5);
        for (SysUser sysUser : sysUserList) {
            System.out.println("用户名称 ==================== 用户权限");
            for (SysRole sysRole : sysUser.getRoles()) {
                System.out.println(sysUser.getReal_name()+ "sysRole.getRoleName() = " + sysRole.getRoleName());
            }
        }
    }

}
