package com.dlms.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlms.demo.entity.Member;
import com.dlms.demo.repository.MemberRepository;
import com.dlms.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    
	@Autowired
	private final MemberRepository memberRepository;

    
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public void addMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void updateMember(Member member) {
        memberRepository.save(member);
    }

	@Override
	public Member saveMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
}

