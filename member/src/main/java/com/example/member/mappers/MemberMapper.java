package com.example.member.mappers;

import com.example.member.dto.MemberDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member VALUES(NULL,#{userid},#{passwd},#{username},NOW())")
    void setInsert(MemberDto memberDto);

    @Select("SELECT * FROM member ${queryString} ORDER BY id DESC")
    List<MemberDto> getMemberList(String queryString);

    @Select("SELECT COUNT(*) FROM member ${queryString}")
    int getMemberCount(String queryString);

    @Delete("DELETE FROM member WHERE id = #{id}")
    void deleteMember(int id);
}
