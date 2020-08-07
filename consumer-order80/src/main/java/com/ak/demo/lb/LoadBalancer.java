/*
 * FileName: LoadBalancer
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Akeung
 * 2020/8/7
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instances);
}
