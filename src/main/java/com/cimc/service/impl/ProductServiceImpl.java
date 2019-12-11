package com.cimc.service.impl;

import com.cimc.bo.ProductBo;
import com.cimc.bo.ProductInfoBo;
import com.cimc.dao.ProductCategoryDao;
import com.cimc.dao.ProductInfoDao;
import com.cimc.po.ProductCategoryPo;
import com.cimc.po.ProductInfoPo;
import com.cimc.service.ProductService;
import com.cimc.vo.ProductInfoVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao piDao;

    @Autowired
    private ProductCategoryDao pcDao;


    @Override
    public List<ProductBo> getProduct() {
        // 查询所有的上架商品
        List<ProductInfoPo> ProductInfoList=piDao.selectByExample(new ProductInfoVo());

        // lambda表达式
        List<Integer> categoryTypeList = ProductInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategoryPo> productCategoryList=  pcDao.selectByIdSet(categoryTypeList);

        // 3.数据拼装
        List<ProductBo> ProductBoList = new ArrayList<>();
        for (ProductCategoryPo pcPo: productCategoryList){
            ProductBo productBo=new ProductBo();
            productBo.setCategoryType(pcPo.getCategoryType());
            productBo.setCategoryName(pcPo.getCategoryName());
            List<ProductInfoBo> ProductInfoBoList=new ArrayList<>();
            for (ProductInfoPo piPo:ProductInfoList){
               if (piPo.getCategoryType().equals(pcPo.getCategoryType())){
                   ProductInfoBo pibo=new ProductInfoBo();
                   pibo.setProductId(piPo.getProductId());
                   pibo.setProductName(piPo.getProductName());
                   pibo.setProductPrice(piPo.getProductPrice());
                   pibo.setProductDescription(piPo.getProductDescription());
                   pibo.setProductIcon(piPo.getProductIcon());
                   ProductInfoBoList.add(pibo);
               }
            }
            productBo.setFoods(ProductInfoBoList);
            ProductBoList.add(productBo);
        }

        return ProductBoList;
    }
}
