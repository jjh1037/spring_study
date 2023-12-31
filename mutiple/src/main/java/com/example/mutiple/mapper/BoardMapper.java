package com.example.mutiple.mapper;

import com.example.mutiple.dto.BoardDto;
import com.example.mutiple.dto.FileDto;
import org.apache.ibatis.annotations.*;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface BoardMapper {
    @Select("SELECT IFNULL(MAX(grp), 1) FROM board_${configCode}")
    public int getGrpMaxCnt(String configCode);
    @Insert("INSERT INTO board_${configCode} VALUES(null, #{subject}, #{writer}, #{content}, 0, now(), #{grp}, #{seq}, 1, #{isFiles})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // ex) 1번 게시물에 3개의 이미지를 저장할 시 id값을 찾아 다른 db에 id 값을 넣기위한 것
    public void setBoard(BoardDto boardDto);

    @Insert("INSERT INTO files_${configCode} VALUES(#{id}, #{orgName}, #{savedFileName}, #{savedPathName}, #{savedFileSize}, #{folderName}, #{ext})")
    public void setFiles(FileDto fileDto);

    @Select("SELECT * FROM board_${configCode} ${searchQuery} ORDER BY grp DESC, seq ASC LIMIT #{startNum}, #{offset}")
    public List<BoardDto> getBoardList(Map<String, Object> map);

    @Select("SELECT * FROM board_${configCode} WHERE id = #{id}")
    public BoardDto getBoard(String configCode, int id);

    @Select("SELECT * FROM files_${configCode} WHERE id = #{id}")
    public List<FileDto> getFiles(String configCode, int id);

    @Delete("DELETE FROM board_${configCode} WHERE id = #{id}")
    public void getBoardDelete(BoardDto boardDto);

    @Delete("DELETE FROM files_${configCode} WHERE id = #{id}")
    public void setFilesDelete(BoardDto boardDto);

    @Delete("DELETE FROM comment_${configCode} WHERE b_id = #{id}")
    public void setCommentDelete(BoardDto boardDto);

    @Select("SELECT COUNT(*) FROM board_${configCode} ${searchQuery}") // 페이지
    public int getBoardCount(String configCode, String searchQuery);

    @Select("SELECT * FROM files_${configCode} WHERE savedFileName = #{savedFileName}")
    FileDto getFile(String configCode, String savedFileName);

//  계층형 게시판에서 답글 순서를 변경하는 업데이트 작업
    @Update("UPDATE board_${configCode} SET seq = seq + 1 WHERE grp = #{grp} AND seq > #{seq}")
    void setReplyUpdate(BoardDto boardDto);


}
