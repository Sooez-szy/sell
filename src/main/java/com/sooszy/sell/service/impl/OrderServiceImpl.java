package com.sooszy.sell.service.impl;

import com.google.common.collect.Lists;
import com.sooszy.sell.dataobject.OrderDetail;
import com.sooszy.sell.dataobject.OrderMaster;
import com.sooszy.sell.dataobject.ProductInfo;
import com.sooszy.sell.dto.CartDTO;
import com.sooszy.sell.dto.OrderDTO;
import com.sooszy.sell.enums.ResultEnum;
import com.sooszy.sell.exception.SellExpection;
import com.sooszy.sell.repository.OrderDetailRepository;
import com.sooszy.sell.repository.OrderMasterRepository;
import com.sooszy.sell.service.OrderService;
import com.sooszy.sell.service.ProductService;
import com.sooszy.sell.util.BigDecimalUtil;
import com.sooszy.sell.util.KeyUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午10:48
 **/
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //查询商品
        if(CollectionUtils.isNotEmpty(orderDTO.getOrderDetailList())){
            for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
                ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
                if(productInfo == null) {
                    throw new SellExpection(ResultEnum.PRODUCT_NOT_EXIST);
                }
                //计算订单总价
                orderAmount = BigDecimalUtil.mul(orderDetail.getProductPrice().doubleValue(),orderDetail.getProductQuantity()).add(orderAmount);

                //订单详情入库( orderDetail)
                orderDetail.setOrderId(orderId);
                orderDetail.setDetailId(KeyUtil.genUniqueKey());
                BeanUtils.copyProperties(productInfo,orderDetail);
                orderDetailRepository.save(orderDetail);

            }
        }
        //写入数据库（orderMaster）
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMasterRepository.save(orderMaster);

        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
            new CartDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());
        //下单成功 扣库存
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
