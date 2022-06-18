package com.example.server.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.entity.CloudMenuRoleEntity;
import com.example.server.utils.PageUtils;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
public interface CloudMenuRoleService extends IService<CloudMenuRoleEntity>
{

    PageUtils queryPage(Map<String, Object> params);

    List<Integer> selectMenusWithRoleList(List<Integer> roleList);
}

