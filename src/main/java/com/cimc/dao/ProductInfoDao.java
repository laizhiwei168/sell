package com.cimc.dao;

import com.cimc.po.ProductInfoPo;
import com.cimc.vo.ProductInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoDao {
	int findByCount(ProductInfoVo vo);
    
    List<ProductInfoPo> selectByExample(ProductInfoVo vo);
    
    int insert(ProductInfoPo po);

    int update(ProductInfoPo po);
}