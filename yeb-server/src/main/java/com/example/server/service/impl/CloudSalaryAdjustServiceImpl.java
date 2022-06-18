package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudSalaryAdjustDao;
import com.example.server.pojo.entity.CloudSalaryAdjustEntity;
import com.example.server.service.CloudSalaryAdjustService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudSalaryAdjustService")
public class CloudSalaryAdjustServiceImpl extends ServiceImpl<CloudSalaryAdjustDao,CloudSalaryAdjustEntity> implements CloudSalaryAdjustService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudSalaryAdjustEntity> page = this.page(
                new Query<CloudSalaryAdjustEntity>().getPage(params),
                new QueryWrapper<CloudSalaryAdjustEntity>()
        );

        return new PageUtils(page);
    }

}