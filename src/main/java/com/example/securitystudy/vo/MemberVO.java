package com.example.securitystudy.vo;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class MemberVO {

    private Long id;
    private String userid;
    private String pw;
    private String roles;

    private MemberVO(Long id, String userid, String pw, String roleUser) {
        this.id = id;
        this.userid = userid;
        this.pw = pw;
        this.roles = roleUser;
    }

    protected MemberVO() {}

    public static MemberVO createUser(String userId, String pw, PasswordEncoder passwordEncoder) {
        return new MemberVO(null, userId, passwordEncoder.encode(pw), "USER");
    }
    
}
