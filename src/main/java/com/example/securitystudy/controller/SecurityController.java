package com.example.securitystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securitystudy.service.MemberService;
import com.example.securitystudy.service.RegisterMemberService;

@Controller
@RequestMapping("/view")
public class SecurityController {

    @Autowired
    MemberService memberService;

    @Autowired
    RegisterMemberService RegisterMemberService;


    @GetMapping("/test")
    public String first(){
        System.out.println("test");
        return "test";
    }

    @GetMapping("/login")
    public String index(){
        System.out.println("login");
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        System.out.println("join");
        return "join";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        System.out.println("dashboard");
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String adminPage() {
        System.out.println("adminPage");
        return "admin";
    }

    
}
