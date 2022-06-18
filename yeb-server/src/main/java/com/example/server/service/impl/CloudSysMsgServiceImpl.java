package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudSysMsgDao;
import com.example.server.pojo.entity.CloudSysMsgEntity;
import com.example.server.service.CloudSysMsgService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudSysMsgService")
public class CloudSysMsgServiceImpl extends ServiceImpl<CloudSysMsgDao,CloudSysMsgEntity> implements CloudSysMsgService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudSysMsgEntity> page = this.page(
                new Query<CloudSysMsgEntity>().getPage(params),
                new QueryWrapper<CloudSysMsgEntity>()
        );

        return new PageUtils(page);
    }

}