/*
 * FileName: StorageService
 * Author:   Akeung
 * Date:     2020/8/14
 */
package com.ak.demo.service;

/**
 * @author Akeung
 * 2020/8/14
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    void decrease( Long productId,Integer count);
}
