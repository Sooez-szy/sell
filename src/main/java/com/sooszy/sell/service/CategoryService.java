package com.sooszy.sell.service;

import com.sooszy.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 * @author 沈躜毅
 * @create 2017-12-29 下午5:35
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
