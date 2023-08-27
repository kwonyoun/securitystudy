package com.example.securitystudy.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.securitystudy.service.MemberService;
import com.example.securitystudy.vo.MemberVO;

@Component
public class MyUserDetailsService implements UserDetailsService{

    //@Autowired 대신 service불러오기
    //이 방법을 '생성자 주입 방식'이라고 한다??
    private final MemberService memberService;
    public MyUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }
    

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        //id로 정보 가져오기
        Optional<MemberVO> findOne = memberService.findOne(insertedUserId);
        System.out.println("MyUserDetailsService: "+findOne);

        MemberVO member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(member.getUserid()) //가져온 정보에서 userid
                .password(member.getPw()) //가져온 정보에서 pw
                .roles(member.getRoles()) //가져온 정보에서 roles
                .build();
    

    }
    
}
