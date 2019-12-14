package com.springboot.biz;

import com.springboot.po.Clazz;
import com.springboot.po.Student;

import java.util.List;

public interface IStudentBiz {
    public int save(Student st);
    public int update(Student st);
    public int delById(Integer sid);
    public Student findById(Integer sid);

    public List<Student>findPageAll(int page,int rows);
    public int findMaxRow();
    public List<Clazz>doinit();
}
