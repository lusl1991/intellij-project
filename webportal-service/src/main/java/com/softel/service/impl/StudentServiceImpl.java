package com.softel.service.impl;

import com.softel.dao.StudentMapper;
import com.softel.model.Student;
import com.softel.model.utils.ResultVo;
import com.softel.service.StudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    public Boolean addStudent(Student student) {

        return studentMapper.insert(student);
    }

    public Boolean deleteStudentById(Integer id) {
        Student student=new Student();
        student.setId(id);
        return studentMapper.deleteByPrimaryKey(student);
    }

    public Boolean updateStudentById(Student student) {

        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public ResultVo findAllStudent(Student student) {
        ResultVo resultVo=new ResultVo();
        List<Student> list= studentMapper.selectByPrimaryKey(student);
        if (list.size()>0){
            resultVo.setResult(list);
            resultVo.setSuccess(true);
        }else {
            resultVo.setMessage("没有找到相关信息");
        }
        return resultVo;
    }
}
