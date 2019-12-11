package com.cimc.dao;

import com.cimc.po.OrderDetailPo;
import com.cimc.po.ProductCategoryPo;
import com.cimc.vo.OrderDetailVo;
import com.cimc.vo.ProductCategoryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryDao {
    int findByCount(ProductCategoryVo vo);

    List<ProductCategoryPo> selectByExample(ProductCategoryVo vo);

    List<ProductCategoryPo> selectByIdSet (List<Integer> list);

    int insert(ProductCategoryPo po);

    int update(ProductCategoryPo po);
}
