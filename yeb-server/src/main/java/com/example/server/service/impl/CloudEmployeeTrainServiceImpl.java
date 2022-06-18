package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudEmployeeTrainDao;
import com.example.server.pojo.entity.CloudEmployeeTrainEntity;
import com.example.server.service.CloudEmployeeTrainService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudEmployeeTrainService")
public class CloudEmployeeTrainServiceImpl extends ServiceImpl<CloudEmployeeTrainDao,CloudEmployeeTrainEntity> implements CloudEmployeeTrainService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudEmployeeTrainEntity> page = this.page(
                new Query<CloudEmployeeTrainEntity>().getPage(params),
                new QueryWrapper<CloudEmployeeTrainEntity>()
        );

        return new PageUtils(page);
    }

}