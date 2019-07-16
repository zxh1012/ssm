package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("file")
public class UploadController {

    public static String saveDir = "e:\\temp\\lib";

    @RequestMapping("/toUpload")
    public String toUpload(){
        return  "upload";
    }

//    @RequestMapping("/Upload")
//    public String Upload(MultipartFile img, HttpServletRequest request) throws Exception{
//        String filename = img.getOriginalFilename();
//        File targetFile = new File(saveDir + "\\" +filename);
//        img.transferTo(targetFile);
//        request.setAttribute("msg","文件上传成功");
//        return "upload";
//    }

    @RequestMapping("/Upload")
    public String Upload(MultipartFile[] imgs, HttpServletRequest request) throws Exception{
        MultipartFile img = null;
        for (int i = 0; null !=imgs && i<imgs.length;i++){
            img = imgs[i];
            String filename = img.getOriginalFilename();
            File targetFile = new File(saveDir + "\\" +filename);
            img.transferTo(targetFile);
        }
        request.setAttribute("msg","文件上传成功");
        return "upload";
    }

}
