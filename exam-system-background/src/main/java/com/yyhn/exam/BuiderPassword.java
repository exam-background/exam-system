package com.yyhn.exam;

import com.yyhn.exam.service.SysRoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

public class BuiderPassword {

//    public static void main(String[] args){
//
//        BCryptPasswordEncoder pwd = new BCryptPasswordEncoder(10);
//        String str = pwd.encode("chenmin");
//        System.out.println(str);
//
public static void main(String[] args) {

    BCryptPasswordEncoder pwd = new BCryptPasswordEncoder(10);

    System.out.println(pwd.matches("$2a$10$UULAGL.yQsqKMwCGgLZ5Q.zSONJA.d67/oMQpYmff3BEZQlWLPo6m","$2a$10$8r4EaZeDlCuYASSiAMJEkeRq5SIbXNOyAlWk5pK4iLGeVWWm7xY1a"));
}

}
