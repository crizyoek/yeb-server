package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudRoleDao;
import com.example.server.pojo.entity.CloudRoleEntity;
import com.example.server.service.CloudRoleService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudRoleService")
public class CloudRoleServiceImpl extends ServiceImpl<CloudRoleDao,CloudRoleEntity> implements CloudRoleService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudRoleEntity> page = this.page(
                new Query<CloudRoleEntity>().getPage(params),
                new QueryWrapper<CloudRoleEntity>()
        );

        return new PageUtils(page);
    }

}