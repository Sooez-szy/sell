package com.sooszy.sell.repository;

import com.sooszy.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 沈躜毅
 * @create 2018-01-03 下午5:31
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
