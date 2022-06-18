package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudEmployeeDao;
import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.service.CloudEmployeeService;
import org.springframework.stereotype.Service;



@Service("cloudEmployeeService")
public class CloudEmployeeServiceImpl extends ServiceImpl<CloudEmployeeDao,CloudEmployeeEntity> implements CloudEmployeeService
{

    @Override
    public Page queryPage(Page<CloudEmployeeEntity> page, LambdaQueryWrapper<CloudEmployeeEntity> queryWrapper) {
        return this.baseMapper.selectPage(page,queryWrapper);
    }

}