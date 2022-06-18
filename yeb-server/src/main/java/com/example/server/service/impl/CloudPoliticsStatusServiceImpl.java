package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudPoliticsStatusDao;
import com.example.server.pojo.entity.CloudPoliticsStatusEntity;
import com.example.server.service.CloudPoliticsStatusService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("cloudPoliticsStatusService")
public class CloudPoliticsStatusServiceImpl extends ServiceImpl<CloudPoliticsStatusDao,CloudPoliticsStatusEntity> implements CloudPoliticsStatusService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudPoliticsStatusEntity> page = this.page(
                new Query<CloudPoliticsStatusEntity>().getPage(params),
                new QueryWrapper<CloudPoliticsStatusEntity>()
        );

        return new PageUtils(page);
    }

}