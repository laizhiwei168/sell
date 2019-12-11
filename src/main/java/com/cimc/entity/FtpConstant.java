package com.cimc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ftp")
@Data
public class FtpConstant {
    private String ip;
    private Integer port;
    private String username;
    private String password;
    private String imgpath;
    private String videopath;
    private Integer imgport;
    private Integer videoport;

}
