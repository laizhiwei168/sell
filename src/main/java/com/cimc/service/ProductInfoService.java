package com.cimc.service;

import com.cimc.po.ProductInfoPo;
import com.cimc.vo.ProductInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductInfoService {
    int findByCount(ProductInfoVo vo);

    List<ProductInfoPo> selectByExample(ProductInfoVo vo);

    int insert(ProductInfoPo po);

    int update(ProductInfoPo po);
}
