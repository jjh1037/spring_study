package com.example.mutiple.mapper;

import com.example.mutiple.dto.BoardDto;
import com.example.mutiple.dto.FileDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.io.File;
import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT IFNULL(MAX(grp), 1) FROM board_${configCode}")
    public int getGrpMaxCnt(String configCode);
    @Insert("INSERT INTO board_${configCode} VALUES(null, #{subject}, #{writer}, #{content}, 0, now(), #{grp}, 1, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id") // ex) 1번 게시물에 3개의 이미지를 저장할 시 id값을 찾아 다른 db에 id 값을 넣기위한 것
    public void setBoard(BoardDto boardDto);

    @Insert("INSERT INTO files_${configCode} VALUES(#{id}, #{orgName}, #{savedFileName}, #{savedPathName}, #{savedFileSize}, #{folderName}, #{ext})")
    public void setFiles(FileDto fileDto);

    @Select("SELECT * FROM board_${configCode} ORDER BY id DESC")
    public List<BoardDto> getBoardList(String configCode);

    @Select("SELECT * FROM board_${configCode} WHERE id = #{id}")
    public BoardDto getBoard(String configCode, int id);

    @Select("SELECT * FROM files_${configCode} WHERE id = #{id}")
    public List<FileDto> getFiles(String configCode, int id);



}
