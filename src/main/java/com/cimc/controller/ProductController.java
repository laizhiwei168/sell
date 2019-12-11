package com.cimc.controller;

import com.cimc.bo.ProductBo;
import com.cimc.entity.Result;
import com.cimc.service.ProductService;
import com.cimc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getProduct")
    private Result getProduct(){
        List<ProductBo> l_bo=productService.getProduct();
        return ResultUtil.SUCCESS(l_bo);
    }

}
