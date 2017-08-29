package com.softel.controller;

import com.softel.model.utils.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/downloadApi/")
public class UpLoadController {

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
        return resultVo;
    }

}
