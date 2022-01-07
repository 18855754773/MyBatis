package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

public class TestMyApp {

    //添加信息
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1006,"关非非","guanferifei@qq.com",21);
        int jieguo = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(jieguo==1?"添加成功":"添加失败");
        sqlSession.close();
    }

    //根据id删除数据
    @Test
    public void testDeleteStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Integer integer = 1006;
        int jieguo = dao.deleteStudent(integer);
        sqlSession.commit();
        System.out.println(jieguo==1?"删除成功":"删除失败");
        sqlSession.close();
    }
    //分页查询
    @Test
    public void testSelectStudentH(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        PageHelper.startPage(1,2);
        List<Student> students = dao.selectStudentH();
        students.forEach(s-> System.out.println(s));
        sqlSession.close();
    }

    //if where 的使用
    @Test
    public void testSelectStudentIW(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        //student.setAge(30);
        List<Student> students = dao.selectStudentIW(student);
        students.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    //列名和属性名对应关系的使用
    @Test
    public void testSelectStudentLS(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentLS();
        students.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    //foreach的使用
    @Test
    public void testSelectStudentForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(1001);
        integers.add(1003);
        List<Student> students = dao.selectStudentForeach(integers);
        students.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
}
