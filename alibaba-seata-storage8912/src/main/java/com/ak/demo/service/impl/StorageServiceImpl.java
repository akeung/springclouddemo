/*
 * FileName: StorageServiceImpl
 * Author:   Akeung
 * Date:     2020/8/15
 */
package com.ak.demo.service.impl;

import com.ak.demo.mapper.StorageMapper;
import com.ak.demo.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Akeung
 * 2020/8/15
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("seata-storage##decrease storage start=======");
        storageMapper.decrease(productId,count);
        log.info("seata-storage##end");
    }
}
