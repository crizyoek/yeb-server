package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudEmployeeDao;
import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.service.CloudEmployeeService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudEmployeeService")
public class CloudEmployeeServiceImpl extends ServiceImpl<CloudEmployeeDao,CloudEmployeeEntity> implements CloudEmployeeService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudEmployeeEntity> page = this.page(
                new Query<CloudEmployeeEntity>().getPage(params),
                new QueryWrapper<CloudEmployeeEntity>()
        );

        return new PageUtils(page);
    }

}