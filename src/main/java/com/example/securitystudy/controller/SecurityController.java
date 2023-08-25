package com.example.securitystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.securitystudy.service.MemberService;

@Controller
@RequestMapping("/view")
public class SecurityController {

    // @Autowired
    // MemberService memberService;


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

    // @PostMapping("/login-process")
    // public String login(@AuthenticationPrincipal User user) {
    //     // boolean isValidMember = memberService.isValidMember(dto.getMemId(), dto.getMemPw());
    //     // if (isValidMember)
    //     //     return "dashboard";
    //     System.out.println(user.getUsername());
    //     System.out.println(user.getPassword());
    //     return "test";
    // }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        System.out.println("dashboard");
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "dashboard";
    }

    
}
