package com.service;

import com.mapper.CourseMapper;
import com.pojo.Course;
import com.pojo.PageBean;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SelectService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();



    public PageBean<Course> selectCourse(int currentPage, int pageSize, Course course){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<Course> rows = mapper.selectCourse(begin,size,course);
        int totalCount = mapper.selectTotalCountCourse(course);
        //封装PageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    public PageBean<User> selectTeacher(int currentPage, int pageSize, User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<User> rows = mapper.selectTeacher(begin,size,user);
        int totalCount = mapper.selectTotalCountTeacher(user);
        //封装PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<User> selectStudent(int currentPage, int pageSize, User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<User> rows = mapper.selectStudent(begin,size,user);
        int totalCount = mapper.selectTotalCountStudent(user);
        //封装PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    //新增课程
    public void addCourse(Course course){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.addCourse(course);
        sqlSession.commit();
        sqlSession.close();
    }
    //新增教师
    public void addTeacher(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.addTeacher(user);
        sqlSession.commit();
        sqlSession.close();
    }
    //新增学生
    public void addStudent(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.addStudent(user);
        sqlSession.commit();
        sqlSession.close();
    }
    
    //删除课程
    public void deleteCourseById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.deleteCourseById(id);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除教师
    public void deleteTeacherById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.deleteTeacherById(id);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除学生
    public void deleteStudentById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.deleteStudentById(id);
        sqlSession.commit();
        sqlSession.close();
    }
    
    //修改课程信息
    public void upDateCourse(Course course){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.upDateCourse(course);
        sqlSession.commit();
        sqlSession.close();
    }
    //修改课程信息
    public void upDateTeacher(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.upDateTeacher(user);
        sqlSession.commit();
        sqlSession.close();
    }
    //修改课程信息
    public void upDateStudent(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.upDateStudent(user);
        sqlSession.commit();
        sqlSession.close();
    }

    //学生查看可选课程
    public PageBean<Course> selectCourse_Optional(int currentPage, int pageSize, Course course,int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<Course> rows = mapper.selectCourse_Optional(begin,size,course,id);
        int totalCount = mapper.selectTotalCountCourse_Optional(course,id);
        //封装PageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    //学生查看已选课程
    public PageBean<Course> selectCourse_Selected(int currentPage, int pageSize, Course course,int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<Course> rows = mapper.selectCourse_Selected(begin,size,course,id);
        int totalCount = mapper.selectTotalCountCourse_Selected(course,id);
        //封装PageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    //选课
    public void takeCourse(int id,int courseId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.takeCourse(id,courseId);
        sqlSession.commit();
        sqlSession.close();
    }
    //退选
    public void deselectCourse(int id,int courseId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.deselectCourse(id,courseId);
        sqlSession.commit();
        sqlSession.close();
    }

    //教师查看自己的课程
    public PageBean<Course> selectMyCourse(int currentPage, int pageSize, Course course,String name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        //计算索引
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize ;
        //查询单页
        List<Course> rows = mapper.selectMyCourse(begin,size,course,name);
        int totalCount = mapper.selectTotalCountMyCourse(course,name);
        //封装PageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    public List<User> showNameList(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<User> users = mapper.showNameList(id);
        sqlSession.close();
        return users;
    }

}
