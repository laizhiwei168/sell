package com.cimc.dao;

import com.cimc.po.OrderDetailPo;
import com.cimc.vo.OrderDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {
    int findByCount(OrderDetailVo vo);

    List<OrderDetailPo> selectByExample(OrderDetailVo vo);

    int insert(OrderDetailPo po);

    int update(OrderDetailPo po);
}
