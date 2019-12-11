package com.cimc.dao;

import com.cimc.po.OrderDetailPo;
import com.cimc.po.OrderMasterPo;
import com.cimc.vo.OrderDetailVo;
import com.cimc.vo.OrderMasterVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMasterDao {
    int findByCount(OrderMasterVo vo);

    List<OrderMasterPo> selectByExample(OrderMasterVo vo);

    int insert(OrderMasterPo po);

    int update(OrderMasterPo po);
}
