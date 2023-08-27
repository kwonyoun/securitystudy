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
public class AuthorizationController {  //가입 controller

    //생성자 주입
    private final RegisterMemberService registerMemberService;
    public AuthorizationController(RegisterMemberService registerMemberService) {
        this.registerMemberService = registerMemberService;
    }

    //join.jsp에서 받아옴. 
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberVO vo) {
        System.out.println(vo.getUserid()); //받아왔는지 확인
        try {
            //가입 insert
            registerMemberService.join(vo.getUserid(), vo.getPw());

            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
