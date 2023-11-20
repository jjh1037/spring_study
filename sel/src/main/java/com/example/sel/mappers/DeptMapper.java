package com.example.sel.mappers;

import com.example.sel.dto.DeptDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM dept ORDER BY dept_code ASC")
    List<DeptDto> getDeptAll();

    @Insert("INSERT INTO dept VALUES(#{deptCode}, #{deptName})")
    void addDept(DeptDto deptDto);
}
