package com.example.server.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.entity.CloudDepartmentEntity;
import com.example.server.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
public interface CloudDepartmentService extends IService<CloudDepartmentEntity>
{

    PageUtils queryPage(Map<String, Object> params);
}

