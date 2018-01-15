package com.softel.controller;

import com.softel.model.TbUser;
import com.softel.model.utils.ExcelUtil;
import com.softel.model.utils.InvokeUtil;
import com.softel.model.utils.ResultVo;
import com.softel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lsl
 */
@Controller
@RequestMapping("/api/")
public class UpLoadController {

    @Autowired
    private UserService userService;

    @RequestMapping("upload")
    @ResponseBody
    public ResultVo uploadfile(MultipartFile multipartFile){
        ResultVo resultVo = new ResultVo();
        if(multipartFile.isEmpty()){
            String filename = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();
            if(filename == null || size == 0){
                resultVo.setSuccess(false);
                resultVo.setMessage("文件为空");
            }else{

            }
        }
        return resultVo;
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> downloadtemplate(){
        TbUser tbUser = new TbUser();
        List<Field> columnNames = InvokeUtil.getFields(tbUser);
        List<Method> columnMethods = InvokeUtil.getMethod(tbUser);
        String fileName = "user.xls";

        try {
            ResultVo resultVo = userService.findUser(tbUser);
            List<Object> list = (List<Object>) resultVo.getResult();
            byte[] bs = ExcelUtil.ExportTemplate(columnNames,columnMethods,list);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
            return new ResponseEntity<byte[]>(bs, headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
