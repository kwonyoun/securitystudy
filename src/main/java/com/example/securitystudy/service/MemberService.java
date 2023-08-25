package com.example.securitystudy.service;


import com.example.securitystudy.dao.MemberDao;
import com.example.securitystudy.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberDao dao;

    public Optional<MemberVO> findOne(String userId) {
        System.out.println("MemberService:  "+userId);
        return dao.findByUserid(userId);
    }
}

