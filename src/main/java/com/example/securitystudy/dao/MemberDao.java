package com.example.securitystudy.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.securitystudy.vo.MemberVO;

@Mapper
public interface MemberDao {

    Optional<MemberVO> findByUserid(String userId);
    
}
