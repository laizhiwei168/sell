package com.cimc.utils;

import com.cimc.entity.FtpConstant;
import com.cimc.enums.ResultEnum;
import com.cimc.exception.ArticleException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
 
/**
 * FtpUtil工具类 ftp文件上传类
 *
 * @Author Yuan Jingshan
 * @Date 2018-05-09
 */
@Component
public class FtpUtil {

    @Autowired
    private  FtpConstant ftpConstant;

    public String upload(MultipartFile file){
        String url=null;
        boolean is=false;
        try {
            String filename=file.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            String dataname=UUIDUtil.getUUID()+"."+suffix;
            int port=ftpConstant.getImgport();
            String filePath="";
            // 根据不同文件类型上传到不同文件夹
            if (filename.endsWith("jpg")||filename.endsWith("png")){
                is=uploadImg(dataname,file.getInputStream());
                filePath="/"+ftpConstant.getImgpath();
            }else if(filename.endsWith("mp4")) {
                is=uploadVideo(dataname,file.getInputStream());
                filePath="";//ftpConstant.getVideopath();
                port=ftpConstant.getVideoport();
            }else if(filename.endsWith("zip")||filename.endsWith("rar")) {

            }else {

            }
            //boolean is=clientFtp.uploadFile(gen_filePath+filePath,dataname,file.getInputStream());
            if(is) {
                url="http://"+ftpConstant.getIp()+":"+port+filePath+"/"+dataname;
            }else{
                throw new ArticleException(ResultEnum.UPLOADING_FAULT);
            }
        } catch (IOException e) {
            throw new ArticleException(ResultEnum.UPLOADING_ERROR);
        }
        return url;
    }

    private  boolean uploadImg(String originFileName, InputStream input){
        return uploadFile(originFileName, input,ftpConstant.getImgpath());
    }

    private boolean uploadVideo(String originFileName, InputStream input){
        return uploadFile(originFileName, input,ftpConstant.getVideopath());
    }

 
    private boolean uploadFile(String originFileName, InputStream input,String basepath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(ftpConstant.getIp(), ftpConstant.getPort());// 连接FTP服务器
            ftp.login(ftpConstant.getUsername(), ftpConstant.getPassword());// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.out.println("is save");
                return success;
            }
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);//FTP.BINARY_FILE_TYPE没有这个传输的文件是空
            ftp.makeDirectory(basepath);
            ftp.changeWorkingDirectory(basepath);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            //e.printStackTrace();
            throw new ArticleException(ResultEnum.UPLOADING_ERROR);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
}
