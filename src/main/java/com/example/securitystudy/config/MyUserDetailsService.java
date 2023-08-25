package com.example.securitystudy.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.securitystudy.service.MemberService;
import com.example.securitystudy.vo.MemberVO;

@Component
public class MyUserDetailsService implements UserDetailsService{

    private final MemberService memberService;

    public MyUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }
    

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        Optional<MemberVO> findOne = memberService.findOne(insertedUserId);
        MemberVO member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(member.getUserid())
                .password(member.getPw())
                // .roles(member.getRoles())
                .build();
    }
    
}
