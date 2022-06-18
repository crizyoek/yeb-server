package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudSalaryDao;
import com.example.server.pojo.entity.CloudSalaryEntity;
import com.example.server.service.CloudSalaryService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudSalaryService")
public class CloudSalaryServiceImpl extends ServiceImpl<CloudSalaryDao,CloudSalaryEntity> implements CloudSalaryService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudSalaryEntity> page = this.page(
                new Query<CloudSalaryEntity>().getPage(params),
                new QueryWrapper<CloudSalaryEntity>()
        );

        return new PageUtils(page);
    }

}