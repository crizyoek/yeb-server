package com.example.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.entity.CloudMailLogEntity;
import com.example.server.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
public interface CloudMailLogService extends IService<CloudMailLogEntity>
{

    PageUtils queryPage(Map<String, Object> params);
}

