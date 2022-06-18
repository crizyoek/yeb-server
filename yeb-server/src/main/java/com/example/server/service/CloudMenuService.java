package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudMenuEntity;
import com.example.server.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
public interface CloudMenuService extends IService<CloudMenuEntity>
{

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取到所有角色对应的菜单
     * @return
     */
	List<CloudMenuEntity> getMenusWithRole();

    /**
     * 通过角色List获取菜单
     * @param roleList
     * @return
     */
    List<CloudMenuEntity> getMenusWithRoleList(List<Integer> roleList);

    /**
     * 通过用户ID查询菜单列表
     * @return
     */
    RespBean getMenusByAdminId(Integer adminId);
}

