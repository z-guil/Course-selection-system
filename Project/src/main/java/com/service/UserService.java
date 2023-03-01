package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User selectFromRoot(String id,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectFromRoot(id, password);
        sqlSession.close();
        return user;
    }
    public User selectFromTeacher(String id,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectFromTeacher(id, password);
        sqlSession.close();
        return user;
    }
    public User selectFromStudent(String id,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectFromStudent(id, password);
        sqlSession.close();
        return user;
    }
    public User showStudentInfo(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.showStudentInfo(id);
        sqlSession.close();
        return user;
    }

    public void updateStudentPassword(int id,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateStudentPassword(id,password);
        sqlSession.commit();
        sqlSession.close();

    }

    public User showTeacherInfo(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.showTeacherInfo(id);
        sqlSession.close();
        return user;
    }

    public void updateTeacherPassword(int id,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateTeacherPassword(id,password);
        sqlSession.commit();
        sqlSession.close();

    }
    


}
