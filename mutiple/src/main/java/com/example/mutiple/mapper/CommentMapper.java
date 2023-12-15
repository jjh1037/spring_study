package com.example.mutiple.mapper;

import com.example.mutiple.dto.CommentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comment_${configCode} VALUES(NULL, #{bId}, #{cSubject}, #{cWriter}, #{cComment}, 0, NOW())")
    void setComment(CommentDto commentDto);

    @Select("SELECT * FROM comment_${configCode} WHERE b_id = #{bId}")
    List<CommentDto> getCommentList(CommentDto commentDto);
}
