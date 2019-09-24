package com.riji.controller;

import org.apache.catalina.connector.OutputBuffer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 上传  页面是upload.html
 */
@RestController
public class uploadController {
    @RequestMapping("/upload")
    public void upLoad(@RequestParam("file")MultipartFile file)throws Exception{
        //得到上传文件的文件名
        String uploadFileName = file.getOriginalFilename();
        System.out.println("uploadFlePath:" + uploadFileName);//uploadFlePath:1553046455(1).jpg
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFileName));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
