package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudEmployeeRemoveDao;
import com.example.server.pojo.entity.CloudEmployeeRemoveEntity;
import com.example.server.service.CloudEmployeeRemoveService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudEmployeeRemoveService")
public class CloudEmployeeRemoveServiceImpl extends ServiceImpl<CloudEmployeeRemoveDao,CloudEmployeeRemoveEntity> implements CloudEmployeeRemoveService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudEmployeeRemoveEntity> page = this.page(
                new Query<CloudEmployeeRemoveEntity>().getPage(params),
                new QueryWrapper<CloudEmployeeRemoveEntity>()
        );

        return new PageUtils(page);
    }

}