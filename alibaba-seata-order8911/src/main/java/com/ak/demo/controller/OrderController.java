package com.ak.demo.controller;


import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Order;
import com.ak.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Akeung
 * @since 2020-08-14
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"create order successful");
    }
}
