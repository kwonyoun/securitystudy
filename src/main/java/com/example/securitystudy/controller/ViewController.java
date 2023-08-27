package com.example.securitystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securitystudy.config.AdminAuthorize;
import com.example.securitystudy.config.UserAuthorize;
import com.example.securitystudy.service.MemberService;
import com.example.securitystudy.service.RegisterMemberService;

@Controller
@RequestMapping("/view")
public class ViewController {

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
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/setting/admin")
    @AdminAuthorize //confing.AdminAuthorize
    public String adminSettingPage() {
        return "admin_setting";
    }

    @GetMapping("/setting/user")
    @UserAuthorize
    public String userSettingPage() {
        return "user_setting";
    }

    
}
