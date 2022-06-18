package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudPositionDao;
import com.example.server.pojo.entity.CloudPositionEntity;
import com.example.server.service.CloudPositionService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service("cloudPositionService")
public class CloudPositionServiceImpl extends ServiceImpl<CloudPositionDao,CloudPositionEntity> implements CloudPositionService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudPositionEntity> page = this.page(
                new Query<CloudPositionEntity>().getPage(params),
                new QueryWrapper<CloudPositionEntity>()
        );

        return new PageUtils(page);
    }

//    @Override
//    public void save(SaveCloudPosition cloudPosition) {
//        CloudPositionEntity cloudPositionEntity = new CloudPositionEntity();
//        BeanUtils.copyProperties(cloudPosition, cloudPositionEntity);
//        cloudPositionEntity.setCreatedate(new Date());
//        baseMapper.insert(cloudPositionEntity);
//    }
//
//    @Override
//    public void updateById(UpdateCloudPosition cloudPosition) {
//        CloudPositionEntity cloudPositionEntity = new CloudPositionEntity();
//        BeanUtils.copyProperties(cloudPosition, cloudPositionEntity);
//        cloudPositionEntity.setCreatedate(new Date());
//        baseMapper.updateById(cloudPositionEntity);
//    }

}