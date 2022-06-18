package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudOplogDao;
import com.example.server.pojo.entity.CloudOplogEntity;
import com.example.server.service.CloudOplogService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudOplogService")
public class CloudOplogServiceImpl extends ServiceImpl<CloudOplogDao,CloudOplogEntity> implements CloudOplogService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudOplogEntity> page = this.page(
                new Query<CloudOplogEntity>().getPage(params),
                new QueryWrapper<CloudOplogEntity>()
        );

        return new PageUtils(page);
    }

}