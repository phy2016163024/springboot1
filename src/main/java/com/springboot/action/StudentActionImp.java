package com.springboot.action;

import com.springboot.biz.IStudentBiz;
import com.springboot.po.Clazz;
import com.springboot.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class StudentActionImp implements  IStudentAction {
   @Autowired
   private IStudentBiz studentBiz;

    public IStudentBiz getStudentBiz() {
        return studentBiz;
    }

    public void setStudentBiz(IStudentBiz studentBiz) {
        this.studentBiz = studentBiz;
    }

    @Override
    @RequestMapping(value = "save_Student.do")
    public int save(HttpServletRequest request, HttpServletResponse response, Student st) {
        return studentBiz.save(st);
    }

    @Override
    @RequestMapping(value = "update_Student.do")
    public int update(HttpServletRequest request, HttpServletResponse response, Student st) {
        return studentBiz.update(st);
    }

    @Override
    @RequestMapping(value = "delById_Student.do")
    public int delById(HttpServletRequest request, HttpServletResponse response, Integer sid) {
        return studentBiz.delById(sid);
    }

    @Override
    @RequestMapping(value = "findById_Student.do")
    public Student findById(HttpServletRequest request, HttpServletResponse response, Integer sid) {
        return studentBiz.findById(sid);
    }

    @Override
    @RequestMapping(value = "findPageAll_Student.do")
    public Map<String, Object> findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
        page=page==null||page<1?1:page;
        rows=rows==null||rows<1?5:rows;
        int maxrow=studentBiz.findMaxRow();
        int maxpage=1;
        if (rows>20)rows=20;
         if (maxrow>0)   {
            maxpage=maxrow%rows==0?maxrow/rows:maxrow/rows+1;


         }
        List<Student>list=studentBiz.findPageAll(page,rows);
        Map<String,Object>map=new HashMap<>();
        map.put("page",page);
        map.put("rows",rows);
        map.put("maxpage",maxpage);
        map.put("list",list);

        return map;
    }

    @Override
    @RequestMapping(value = "doinit_Student.do")
    public List<Clazz> doinit(HttpServletRequest request, HttpServletResponse response) {
        List<Clazz>list=studentBiz.doinit();
        return list;
    }
}
