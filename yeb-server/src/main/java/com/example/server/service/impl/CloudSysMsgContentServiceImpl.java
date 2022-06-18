package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudSysMsgContentDao;
import com.example.server.pojo.entity.CloudSysMsgContentEntity;
import com.example.server.service.CloudSysMsgContentService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudSysMsgContentService")
public class CloudSysMsgContentServiceImpl extends ServiceImpl<CloudSysMsgContentDao,CloudSysMsgContentEntity> implements CloudSysMsgContentService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudSysMsgContentEntity> page = this.page(
                new Query<CloudSysMsgContentEntity>().getPage(params),
                new QueryWrapper<CloudSysMsgContentEntity>()
        );

        return new PageUtils(page);
    }

}