package com.cimc.service;

import com.cimc.po.SellerInfoPo;
import com.cimc.vo.SellerInfoVo;

import java.util.List;

public interface SellerInfoService {

    List<SellerInfoPo> selectByExample(SellerInfoVo vo);

    int insert(SellerInfoPo po);

    int update(SellerInfoPo po);
}
