package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
 /*增加数据*/
 public int insertStudent(Student student);
 /*根据id删除数据*/
 public int deleteStudent(@Param("myId") Integer id);
 /*数据查询 - 分页查询 一次查询 两条数据*/
 public List<Student> selectStudentH();
 /*数据查询 where if 的使用*/
 public List<Student> selectStudentIW(Student student);
 /*列名和属性名 对应的使用*/
 public List<Student> selectStudentLS();
 /*foreach的使用*/
 public List<Student> selectStudentForeach(List<Integer> integers);
}
