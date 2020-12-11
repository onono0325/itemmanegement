package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Member;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM member")
	List<Member>findAll();

	@Select("SELECT * FROM member WHERE id = #{id}")
	Member findOne(Long id);

	@Insert("INSERT INTO member VALUES(#{id}, #{name}, #{price})")
	void save(Member member);

	@Update("UPDATE member SET name = #{name}, price = #{price} WHERE id = #{id}")
	void update(Member member);

	@Delete("DELETE FROM member WHERE id = #{id}")
	void delete(Long id);
}
