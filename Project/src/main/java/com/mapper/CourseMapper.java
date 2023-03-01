package com.mapper;

import com.pojo.Course;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    //分页条件查询---课程查询
    List<Course> selectCourse(@Param("begin")int begin , @Param("size")int size, @Param("course")Course course);
    //查询总记录数---课程查询
    int selectTotalCountCourse(Course course);
    //教师账户查询
    List<User> selectTeacher(@Param("begin")int begin,@Param("size")int size,@Param("user") User user);
    //教师账户记录数
    int selectTotalCountTeacher(User user);
    //教师账户查询
    List<User> selectStudent(@Param("begin")int begin,@Param("size")int size,@Param("user") User user);
    //教师账户记录数
    int selectTotalCountStudent(User user);
    //新增课程
    void addCourse(Course course);
    //新增教师
    void addTeacher(User user);
    //新增学生
    void addStudent(User user);
    //删除课程
    void deleteCourseById(int id);
    //删除教师
    void deleteTeacherById(int id);
    //删除学生
    void deleteStudentById(int id);
    //修改课程
    void upDateCourse(Course course);
    //修改教师
    void upDateTeacher(User user);
    //修改学生
    void upDateStudent(User user);
    //学生查看可选课程
    List<Course> selectCourse_Optional(@Param("begin")int begin , @Param("size")int size, @Param("course")Course course,@Param("id")int id);
    //查询总记录数---学生查看可选课程
    int selectTotalCountCourse_Optional(@Param("course") Course course,@Param("id") int id);
    //学生查看已选课程
    List<Course> selectCourse_Selected(@Param("begin")int begin , @Param("size")int size, @Param("course")Course course,@Param("id")int id);
    //查询总记录数---学生查看已选课程
    int selectTotalCountCourse_Selected(@Param("course") Course course,@Param("id") int id);
    //学生选课
    void takeCourse(@Param("id") int id,@Param("courseId") int courseId);
    //退选
    void deselectCourse(@Param("id") int id,@Param("courseId") int courseId);
    //教师查看自己的课程
    List<Course> selectMyCourse(@Param("begin")int begin , @Param("size")int size, @Param("course")Course course,@Param("name")String name);
    //查询总记录数--教师查看课程
    int selectTotalCountMyCourse(@Param("course") Course course,@Param("name") String name);
    //查看某节课的学生名单
    List<User> showNameList(int id);

}
