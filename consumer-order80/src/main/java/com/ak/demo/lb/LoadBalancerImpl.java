/*
 * FileName: LoadBalancerImpl
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.lb;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Akeung
 * 2020/8/7
 * @see RoundRobinRule
 */
//@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger nextServerCyclicCounter;

    public LoadBalancerImpl() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    private int incrementAndGetModulo() {
        for (; ; ) {//自旋锁
            int current = nextServerCyclicCounter.get();
//            int next = (current + 1) % modulo;
            int next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = incrementAndGetModulo() % instances.size();
        return instances.get(index);
    }

}
