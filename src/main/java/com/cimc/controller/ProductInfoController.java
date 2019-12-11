package com.cimc.controller;

import com.cimc.entity.Result;
import com.cimc.po.ProductInfoPo;
import com.cimc.service.ProductInfoService;
import com.cimc.utils.RedisUtil;
import com.cimc.utils.ResultUtil;
import com.cimc.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService service;


    @RequestMapping("/getProductInfo")
    public Result getProductInfo(ProductInfoVo vo){
        List<ProductInfoPo> l_po =service.selectByExample(vo);
        System.out.println("po"+l_po);
        return ResultUtil.SUCCESS(l_po);
    }




}
