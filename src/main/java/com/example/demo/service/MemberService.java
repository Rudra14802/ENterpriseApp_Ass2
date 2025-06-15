package com.example.demo.service;

import com.example.demo.model.Member;

import java.util.List;

public interface MemberService {
    Member addMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteMember(Long id);
}
