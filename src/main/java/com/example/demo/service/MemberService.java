package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Member;
import com.example.demo.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Transactional
	public List<Member>findAll(){
		return memberMapper.findAll();
	}
	
	@Transactional
	public Member findOne(Long id) {
		return memberMapper.findOne(id);
	}
	
	@Transactional
	public void save (Member member) {
		memberMapper.save(member);
	}
	
	@Transactional
	public void update(Member member) {
		memberMapper.update(member);
	}
	
	@Transactional
	public void delete(Long id) {
		memberMapper.delete(id);
	}

}
