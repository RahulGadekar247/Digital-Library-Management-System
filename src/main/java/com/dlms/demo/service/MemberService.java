package com.dlms.demo.service;

import java.util.List;

import com.dlms.demo.entity.Member;

public interface MemberService {
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    Member saveMember(Member member);
    void deleteMember(Long id);
	void addMember(Member member);
	void updateMember(Member member);
}
