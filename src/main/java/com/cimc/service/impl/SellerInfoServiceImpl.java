package com.cimc.service.impl;

import com.cimc.dao.SellerInfoDao;
import com.cimc.enums.ResultEnum;
import com.cimc.exception.ArticleException;
import com.cimc.po.SellerInfoPo;
import com.cimc.service.SellerInfoService;
import com.cimc.vo.SellerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoDao dao;

    @Override
    public List<SellerInfoPo> selectByExample(SellerInfoVo vo) {
        List<SellerInfoPo> l_po= dao.selectByExample(vo);
        return l_po;
    }

    @Override
    public int insert(SellerInfoPo po) {
        return 0;
    }

    @Override
    public int update(SellerInfoPo po) {
        return 0;
    }
}
