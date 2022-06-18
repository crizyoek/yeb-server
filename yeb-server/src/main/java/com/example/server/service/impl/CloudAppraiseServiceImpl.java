package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudAppraiseDao;
import com.example.server.pojo.entity.CloudAppraiseEntity;
import com.example.server.service.CloudAppraiseService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudAppraiseService")
public class CloudAppraiseServiceImpl extends ServiceImpl<CloudAppraiseDao,CloudAppraiseEntity> implements CloudAppraiseService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudAppraiseEntity> page = this.page(
                new Query<CloudAppraiseEntity>().getPage(params),
                new QueryWrapper<CloudAppraiseEntity>()
        );

        return new PageUtils(page);
    }

}