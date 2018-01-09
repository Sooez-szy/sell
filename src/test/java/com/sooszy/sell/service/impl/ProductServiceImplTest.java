package com.sooszy.sell.service.impl;

import com.sooszy.sell.dataobject.ProductInfo;
import com.sooszy.sell.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("12");
        Assert.assertEquals("12",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(ProductStatusEnum.UP.getCode().intValue(),productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,10);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        Assert.assertNotEquals(0,productInfoPage.getSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(10);
        productInfo.setProductName("iphonex");
        productInfo.setProductPrice(new BigDecimal(4999.99));
        productInfo.setProductDescription("著名的iphonex");
        productInfo.setProductStock(99);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}