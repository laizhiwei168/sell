package com.cimc.controller.common;

import com.cimc.enums.ResultEnum;
import com.cimc.exception.ArticleException;
import com.cimc.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ftp")
public class FTPController {


    @Autowired
    private FtpUtil ftpUtil;

    @RequestMapping(value = "/saveFile")
    public  Object saveFile(MultipartFile file) {
        if(file==null) {
            throw new ArticleException(ResultEnum.UPLOADING_NULL);
        }
        String url=ftpUtil.upload(file);
        return url;
    }
}
