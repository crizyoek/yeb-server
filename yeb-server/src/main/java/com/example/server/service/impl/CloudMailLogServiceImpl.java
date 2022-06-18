package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudMailLogDao;
import com.example.server.pojo.entity.CloudMailLogEntity;
import com.example.server.service.CloudMailLogService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudMailLogService")
public class CloudMailLogServiceImpl extends ServiceImpl<CloudMailLogDao,CloudMailLogEntity> implements CloudMailLogService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudMailLogEntity> page = this.page(
                new Query<CloudMailLogEntity>().getPage(params),
                new QueryWrapper<CloudMailLogEntity>()
        );

        return new PageUtils(page);
    }

}