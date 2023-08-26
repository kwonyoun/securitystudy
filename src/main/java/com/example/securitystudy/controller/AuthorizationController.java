package com.example.securitystudy.controller;

import com.example.securitystudy.vo.MemberVO;
import com.example.securitystudy.service.RegisterMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private final RegisterMemberService registerMemberService;

    public AuthorizationController(RegisterMemberService registerMemberService) {
        this.registerMemberService = registerMemberService;
    }


    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberVO vo) {
        System.out.println(vo.getUserid());
        try {
            registerMemberService.join(vo.getUserid(), vo.getPw());

            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
