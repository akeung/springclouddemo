/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: OrderServiceImpl
 * Author:   Akeung
 * Date:     2020-08-14
 */
package com.ak.demo.service.impl;

import com.ak.demo.entities.Order;
import com.ak.demo.mapper.OrderMapper;
import com.ak.demo.service.AccountService;
import com.ak.demo.service.OrderService;
import com.ak.demo.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * service
 *
 * @author Akeung
 * 2020-08-14
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @GlobalTransactional(name = "create-order",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        order.setStatus(0);
        log.info("seata-order##create order start======");
        orderMapper.saveOrUpdate(order);
        log.info("order detail:{}",order);

        log.info("seata-order##decrease storage start=======");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("seata-order##decrease account start=======");
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info("seata-order##update order status start=======");
        orderMapper.updateStatus(order.getUserId(),0);

        log.info("seata-order##end");
    }
}
