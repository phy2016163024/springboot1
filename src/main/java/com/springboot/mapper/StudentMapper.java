package com.springboot.mapper;

import com.springboot.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public int save(Student st);
    public int update(Student st);
    public int delById(Integer sid);
    public Student findById(Integer sid);

    public List<Student> findPageAll(Map<String, Object>map);
    public int findMaxRow();

}
