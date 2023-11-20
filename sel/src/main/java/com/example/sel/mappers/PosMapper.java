package com.example.sel.mappers;

import com.example.sel.dto.PosDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PosMapper {
    @Insert("INSERT INTO pos VALUES(#{posCode}, #{posName}, #{deptCode})")
    void addPos(PosDto posDto);

    @Select("SELECT * FROM pos WHERE dept_code = #{deptCode}")
    List<PosDto> getPos(String deptCode);

}
