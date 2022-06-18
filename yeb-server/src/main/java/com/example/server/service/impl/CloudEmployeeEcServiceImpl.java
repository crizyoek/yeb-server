package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudEmployeeEcDao;
import com.example.server.pojo.entity.CloudEmployeeEcEntity;
import com.example.server.service.CloudEmployeeEcService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudEmployeeEcService")
public class CloudEmployeeEcServiceImpl extends ServiceImpl<CloudEmployeeEcDao,CloudEmployeeEcEntity> implements CloudEmployeeEcService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudEmployeeEcEntity> page = this.page(
                new Query<CloudEmployeeEcEntity>().getPage(params),
                new QueryWrapper<CloudEmployeeEcEntity>()
        );

        return new PageUtils(page);
    }

}