package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudNationDao;
import com.example.server.pojo.entity.CloudNationEntity;
import com.example.server.service.CloudNationService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudNationService")
public class CloudNationServiceImpl extends ServiceImpl<CloudNationDao,CloudNationEntity> implements CloudNationService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudNationEntity> page = this.page(
                new Query<CloudNationEntity>().getPage(params),
                new QueryWrapper<CloudNationEntity>()
        );

        return new PageUtils(page);
    }

}