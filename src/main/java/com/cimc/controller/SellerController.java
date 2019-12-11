package com.cimc.controller;

import com.cimc.entity.CookieConstant;
import com.cimc.entity.RedisConstant;
import com.cimc.enums.ResultEnum;
import com.cimc.exception.ArticleException;
import com.cimc.po.SellerInfoPo;
import com.cimc.service.SellerInfoService;
import com.cimc.utils.CookieUtil;
import com.cimc.utils.RedisUtil;
import com.cimc.utils.StringUtil;
import com.cimc.vo.SellerInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerInfoService sellerInfoService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("select")
    public void select(){
        log.info("查询卖家信息");
    }


    @GetMapping("/login")
    public void login(@RequestParam("openid") String openid, HttpServletResponse response, Map<String,Object> map){
        // 1.openid去和数据库里的数据匹配
        if (StringUtil.isBlank(openid)){
            throw new ArticleException(ResultEnum.PARAMETER_ERROR);
        }
        SellerInfoVo vo=new SellerInfoVo();
        vo.setOpenid(openid);
        List<SellerInfoPo> sellerInfoPo=sellerInfoService.selectByExample(vo);
        if(sellerInfoPo.size()>0){
            throw new ArticleException(ResultEnum.NOTSELLER_ERROR);
        }


        // 2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisUtil.set(String.format(RedisConstant.TOKEN,token),openid,expire);
        // 3.设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie !=null){
            String token=cookie.getValue();
            redisUtil.del(String.format(RedisConstant.TOKEN,token));
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
    }
}
