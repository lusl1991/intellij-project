package com.softel.dao;

import com.softel.dao.base.BaseMapper;
import com.softel.model.Student;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentMapper extends BaseMapper<Student> {
    Boolean insert(Student var);

    Boolean deleteByPrimaryKey(Student var);

    Boolean updateByPrimaryKeySelective(Student var);

    List<Student> selectByPrimaryKey(Student var);
}