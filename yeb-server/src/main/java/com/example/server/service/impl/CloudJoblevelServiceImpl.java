package com.example.server.service.impl;

import com.example.server.pojo.dao.CloudJobLevelDao;
import com.example.server.pojo.entity.CloudJobLevelEntity;
import com.example.server.service.CloudJobLevelService;
import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudJobLevelService")
public class CloudJoblevelServiceImpl extends ServiceImpl<CloudJobLevelDao,CloudJobLevelEntity> implements CloudJobLevelService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudJobLevelEntity> page = this.page(
                new Query<CloudJobLevelEntity>().getPage(params),
                new QueryWrapper<CloudJobLevelEntity>()
        );

        return new PageUtils(page);
    }

}