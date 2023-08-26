package com.example.securitystudy.vo;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class MemberVO {

    private Long idno;
    private String userid;
    private String pw;
    private String roles;

    private MemberVO(Long idno, String userid, String pw, String roleUser) {
        this.idno = idno;
        this.userid = userid;
        this.pw = pw;
        this.roles = roleUser;
    }

    protected MemberVO() {}

    public static MemberVO createUser(String userId, String pw, PasswordEncoder passwordEncoder) {
        //여기서 비밀번호 암호화 처리함 .encode()
        return new MemberVO(null, userId, passwordEncoder.encode(pw), "USER");
    }
    
}
