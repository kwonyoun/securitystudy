package com.example.securitystudy.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securitystudy.dao.MemberDao;
import com.example.securitystudy.vo.MemberVO;

@Service
public class RegisterMemberService {    //멤버 등록 서비스

    //autowired대신에 이렇게 불러옴?? @오토와이어드 안써도됌
    //'생성자 주입' 방식 이었따.
    private final PasswordEncoder passwordEncoder;
    private final MemberDao dao;
    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberDao dao) {
        this.passwordEncoder = passwordEncoder;
        this.dao = dao;
    }

    //회원가입
    public int join(String userid, String pw) {

        //비밀번호 인코딩하는 것임.
        MemberVO member = MemberVO.createUser(userid, pw, passwordEncoder);

        //아이디로 select해서 존재하는 정보인지 확인하는 것
        validateDuplicateMember(member);

        //이게 회원가입 insert
        int ss = dao.insertJoin(member);

        System.out.println("join: "+ss);

        return ss;
    }

    //아이디 중복 확인
    //존재하면 예외처리된다. 
    private void validateDuplicateMember(MemberVO member) {
        dao.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
}
