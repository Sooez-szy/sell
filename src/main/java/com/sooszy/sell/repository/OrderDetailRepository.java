package com.sooszy.sell.repository;

import com.sooszy.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午9:07
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);
}
