package com.example.springsecuritystudy.member;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @PostMapping("/user")
    public int user() {
        return Response.SC_OK;
    }

    @PostMapping("/admin")
    public int admin() {
        return Response.SC_OK;
    }

    @PostMapping("/login")
    public int login() {
        return Response.SC_OK;
    }

}
