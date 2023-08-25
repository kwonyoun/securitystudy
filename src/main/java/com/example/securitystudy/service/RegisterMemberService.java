package com.example.securitystudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.securitystudy.dao.MemberDao;
import com.example.securitystudy.vo.MemberVO;

public class RegisterMemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberDao dao;

    @Autowired
    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberDao dao) {
        this.passwordEncoder = passwordEncoder;
        this.dao = dao;
    }

    public Long join(String userid, String pw) {
        MemberVO member = MemberVO.createUser(userid, pw, passwordEncoder);
        validateDuplicateMember(member);
        // dao.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(MemberVO member) {
        dao.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
}
