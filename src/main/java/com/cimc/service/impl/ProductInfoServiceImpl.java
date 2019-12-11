package com.cimc.service.impl;

import com.cimc.dao.ProductInfoDao;
import com.cimc.po.ProductInfoPo;
import com.cimc.service.ProductInfoService;
import com.cimc.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao dao;

    @Override
    public int findByCount(ProductInfoVo vo) {
        return 0;
    }

    @Override
    public List<ProductInfoPo> selectByExample(ProductInfoVo vo) {
        List<ProductInfoPo> l_po=dao.selectByExample(vo);
        return l_po;
    }

    @Override
    public int insert(ProductInfoPo po) {
        return 0;
    }

    @Override
    public int update(ProductInfoPo po) {
        return 0;
    }
}
