//package com.softel.test;
//
//import com.softel.mapper.StudentMapper;
//import com.softel.model.Student;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:config/applicationContext.xml")
//public class DaoTest {
//    @Resource
//    private StudentMapper studentMapper;
//
//    @Test
//    public void addTest() throws Exception {
//        Student student=new Student();
//        student.setName("陈同学");
//        student.setSex(false);
//        student.setAddress("深圳");
//        System.out.println(studentMapper.insert(student));
//    }
//
//    @Test
//    public void deleteTest()throws Exception{
//        Student student=new Student();
//        student.setId(new Integer("1"));
//        System.out.println(studentMapper.deleteByPrimaryKey(student));
//    }
//
//    @Test
//    public void updateTest()throws Exception{
//        Student student=new Student();
//        student.setId(new Integer("1"));
//        student.setAddress("北京");
//        System.out.println(studentMapper.updateByPrimaryKeySelective(student));
//    }
//
//    @Test
//    public void select()throws Exception{
//        List<Student> list=studentMapper.select(null);
//        for (Student s:list){
//            System.out.println(s.toString());
//        }
//    }
//}
