package com.tencentocr.tencent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by jiuyv on 2020/5/20
 */
@RestController
@RequestMapping("/ocr")
public class OCRcontroller {



    @RequestMapping("/parsePicture")
    public String parsePicture(){
        return "Welcome to home";
    }


}

