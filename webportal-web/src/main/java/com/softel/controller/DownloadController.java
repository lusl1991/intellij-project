package com.softel.controller;

import com.softel.model.Student;
import com.softel.model.utils.ExcelUtil;
import com.softel.model.utils.InvokeUtil;
import com.softel.model.utils.ResultVo;
import com.softel.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/downloadApi/")
public class DownloadController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("file")
    public ResponseEntity<byte[]> download() throws IOException {
        File file = new File("F:log.txt");
        String fileName = file.getName();
        String daileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", daileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping("downloadtemplate")
    public ResponseEntity<byte[]> downloadtemplate(){
        Student student = new Student();
        List<Field> columnNames = InvokeUtil.getFields(student);
        List<Method> columnMethods = InvokeUtil.getMethod(student);
        String fileName = "student.xls";

        try {
            String daileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
            ResultVo resultVo = studentService.findAllStudent(null);
            List<Object> list = (List<Object>) resultVo.getResult();
            byte[] bs = ExcelUtil.ExportTemplate(columnNames,columnMethods,list);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", daileName);
            return new ResponseEntity<byte[]>(bs, headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
