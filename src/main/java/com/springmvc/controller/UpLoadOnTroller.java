package com.springmvc.controller;

import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 上传文件
 * @author lees
 */
@Controller
@RequestMapping("/uploadfile")
public class UpLoadOnTroller {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public  String showUploadFilePage() {
        return "/file";
    }

    @RequestMapping(value = "/beginUpload",method = RequestMethod.POST)
    public String beginUpload(@RequestParam("file") MultipartFile file) {

        //调用上传方法
        System.out.println("begin upload");
        userService.beginUpload(file);
        System.out.println("upload end");
        //返回成功页面
        return "successfile";
    }
}
