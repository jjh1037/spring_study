package com.example.board.mapper;

import com.example.board.dto.BoardDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT ifnull(max(grp) + 1, 1) AS maxGrp FROM board")
    int getMaxGrp();

    @Insert("INSERT INTO board VALUES(NULL, #{subject}, #{writer}, #{content}, 0, NOW(), #{orgName}, #{savedFileName}, #{savedFilePathName}, #{savedFileSize}, #{folderName}, #{ext}, #{grp}, 1, 1)")
    void setWrite(BoardDto boardDto);

    @Select("SELECT * FROM board ORDER BY id DESC")
    List<BoardDto> getList();

    @Select("SELECT COUNT(*) FROM board")
    int getListCount();

    @Select("SELECT * FROM board WHERE id = #{id}")
    BoardDto getView(int id);

    @Update("UPDATE board SET visit = visit + 1 WHERE id = #{id}")
    void updateVisit(int id);
}
