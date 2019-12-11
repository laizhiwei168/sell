package com.cimc.dao;

import com.cimc.po.ProductCategoryPo;
import com.cimc.po.SellerInfoPo;
import com.cimc.vo.ProductCategoryVo;
import com.cimc.vo.SellerInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerInfoDao {
    int findByCount(SellerInfoVo vo);

    List<SellerInfoPo> selectByExample(SellerInfoVo vo);

    int insert(SellerInfoPo po);

    int update(SellerInfoPo po);

}
