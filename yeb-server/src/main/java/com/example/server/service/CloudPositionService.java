package com.example.server.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.entity.CloudPositionEntity;
import com.example.server.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
public interface CloudPositionService extends IService<CloudPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

