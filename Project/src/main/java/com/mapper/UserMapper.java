package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectFromRoot(@Param("id") String name, @Param("password") String password);
    User selectFromTeacher(@Param("id") String id, @Param("password") String password);
    User selectFromStudent(@Param("id") String id, @Param("password") String password);

    User showStudentInfo(int id);
    void updateStudentPassword(@Param("id") int id,@Param("password") String password);

    User showTeacherInfo(int id);
    void updateTeacherPassword(@Param("id") int id,@Param("password") String password);

}
