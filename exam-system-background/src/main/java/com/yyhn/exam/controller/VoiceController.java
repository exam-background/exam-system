package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class VoiceController {

    @RequestMapping("/uploadVoice")
    public ResultMsg uploadVoice(@RequestParam(name = "file") MultipartFile multipartFile, HttpServletRequest request){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 文件上传后存放的位置为:classpath:/static/uploadFile/
        String realPath = request.getSession().getServletContext().getRealPath("/static/uploadFile/");
        String format = simpleDateFormat.format(new Date());
        File file = new File(realPath+format);
        // 判断文件夹是否存在，不存在就创建文件夹
        if(!file.isDirectory()){
            file.mkdirs();
        }
        // 获取上传名称，生成新的名称。防止重名
        String oldName = multipartFile.getOriginalFilename();
        System.out.println("realPath====================>"+realPath);
//        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try{
            // 文件保存
            multipartFile.transferTo(new File(file, oldName));
            //生成上传文件的访问路径
            String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/static/uploadFile/"+format+"/"+oldName;
            System.out.println("filePath====================>"+filePath);
            return ResultMsg.BY_SUCCESS("成功",filePath);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ResultMsg.BY_FAIL("上传失败");
    }
}
