package com.example.mutiple.mapper;

import com.example.mutiple.dto.ConfigDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConfigMapper {

    @Select("SELECT COUNT(*) FROM config WHERE config_code = #{configCode}")
    int getCheckConfigCode(String configCode);

    @Insert("INSERT INTO config VALUES(NULL, #{configCode}, #{configTitle}, #{configComment}, #{configColor}, NOW())")
    void setConfig(ConfigDto configDto);

    // board_테이블 생성
    @Select("create table board_${configCode}(\n" +
            "id int not null auto_increment,\n" +
            "subject varchar(255) not null,\n" +
            "writer varchar(20) not null,\n" +
            "content text,\n" +
            "visit int,\n" +
            "regdate date,\n" +
            "grp int,\n" +
            "seq int,\n" +
            "depth int,\n" +
            "primary key(id)\n" +
            ");")
    void makeBoard(String configCode);

    // files_테이블 생성
    @Select("create table files_${configCode}(\n" +
            "id int not null,\n" +
            "orgName varchar(255),\n" +
            "savedFileName varchar(255),\n" +
            "savedPathName varchar(255),\n" +
            "savedFileSize bigint,\n" +
            "folderName varchar(10),\n" +
            "ext varchar(20)\n" +
            ");")
    void makeFile(String configCode);

    // comment_테이블 생성
    @Select("create table comment_${configCode}(\n" +
            "c_id int not null auto_increment,\n" +
            "c_subject varchar(50),\n" +
            "c_writer varchar(20),\n" +
            "c_comment varchar(100),\n" +
            "c_visit int,\n" +
            "c_regdate date,\n" +
            "primary key(c_id)\n" +
            ");")
    void makeComment(String configCode);

    @Select("SELECT * FROM config ORDER BY config_id DESC")
    List<ConfigDto> getConfigList();

    @Update("UPDATE config SET config_color = #{color} WHERE config_id = #{id}")
    void getColorChange(int id, String color);

    @Delete("DELETE FROM config WHERE config_code = #{configCode}")
    void deleteConfig(String configCode);

    // board_테이블 삭제
    @Select("DROP TABLE board_${configCode}")
    void dropBoard(String configCode);

    @Select("DROP TABLE files_${configCode}")
    void dropFile(String configCode);

    @Select("DROP TABLE comment_${configCode}")
    void dropComment(String configCode);
}
