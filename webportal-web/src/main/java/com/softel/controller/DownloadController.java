package com.softel.controller;

import com.softel.model.utils.ExcelUtil;
import com.softel.model.utils.ResultVo;
import org.apache.commons.io.FileUtils;
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

@Controller
@RequestMapping("/downloadApi/")
public class DownloadController {

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
        String columnName[] = {"姓名", "性别", "地址"};
        String fileName = "student.xls";

        try {
            String daileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
            byte[] bs = ExcelUtil.ExportTemplate(columnName,null);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", daileName);
            return new ResponseEntity<byte[]>(bs, headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("uploadfile")
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
        return null;
    }

}
