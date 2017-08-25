package com.softel.controller;

import com.softel.model.utils.ExportExcelUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String columnName[] = {"注册时间", "用户号码", "旧号码", "操作渠道"};
        try {
            byte[] bs = ExportExcelUtil.ExportTemplate(columnName,"账单");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(bs, headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
