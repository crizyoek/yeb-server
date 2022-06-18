package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudAdminRoleDao;
import com.example.server.pojo.entity.CloudAdminRoleEntity;
import com.example.server.service.CloudAdminRoleService;
import com.example.server.utils.PageUtils;
import com.example.server.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;


@Service("cloudAdminRoleService")
public class CloudAdminRoleServiceImpl extends ServiceImpl<CloudAdminRoleDao, CloudAdminRoleEntity> implements CloudAdminRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudAdminRoleEntity> page = this.page(
                new Query<CloudAdminRoleEntity>().getPage(params),
                new QueryWrapper<CloudAdminRoleEntity>());

        return new PageUtils(page);
    }

    @Override
    public List<CloudAdminRoleEntity> getAdminRoleList(Integer adminId) {
        return baseMapper.selectList(new LambdaQueryWrapper<CloudAdminRoleEntity>().eq(CloudAdminRoleEntity::getAdminId, adminId));
    }

}