package com.example.server.service.impl;

import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudDepartmentDao;
import com.example.server.pojo.entity.CloudDepartmentEntity;
import com.example.server.service.CloudDepartmentService;
import com.example.server.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("cloudDepartmentService")
public class CloudDepartmentServiceImpl extends ServiceImpl<CloudDepartmentDao,CloudDepartmentEntity> implements CloudDepartmentService
{

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        /**
         * 获取所有部门，要有子节点
         */
        IPage<CloudDepartmentEntity> page = this.page(
                new Query<CloudDepartmentEntity>().getPage(params),
                new QueryWrapper<CloudDepartmentEntity>()
        );

        return new PageUtils(page);
    }

}