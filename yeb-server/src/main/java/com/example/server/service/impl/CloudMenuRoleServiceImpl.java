package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudMenuRoleDao;
import com.example.server.pojo.entity.CloudMenuRoleEntity;
import com.example.server.service.CloudMenuRoleService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("cloudMenuRoleService")
public class CloudMenuRoleServiceImpl extends ServiceImpl<CloudMenuRoleDao, CloudMenuRoleEntity> implements CloudMenuRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudMenuRoleEntity> page = this.page(
                new Query<CloudMenuRoleEntity>().getPage(params),
                new QueryWrapper<CloudMenuRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Integer> selectMenusWithRoleList(List<Integer> roleList) {
        return baseMapper.selectList(new LambdaQueryWrapper<CloudMenuRoleEntity>()
                .in(CloudMenuRoleEntity::getRid, roleList)).stream()
                .map(CloudMenuRoleEntity::getMid).collect(Collectors.toList());
    }

}