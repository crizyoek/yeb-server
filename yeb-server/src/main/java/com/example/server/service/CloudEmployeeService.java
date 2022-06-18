package com.example.server.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.entity.CloudEmployeeEntity;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
public interface CloudEmployeeService extends IService<CloudEmployeeEntity>
{

    Page queryPage(Page<CloudEmployeeEntity> page, LambdaQueryWrapper<CloudEmployeeEntity> queryWrapper);
}

