package com.example.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudAdminEntity;
import com.example.server.pojo.entity.CloudRoleEntity;
import com.example.server.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
public interface CloudAdminService extends IService<CloudAdminEntity>
{

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param httpServletRequest
     * @return
     */
	RespBean login(String username,String password,String code,HttpServletRequest httpServletRequest);

	CloudAdminEntity getAdminByUserName(String username);

	List<CloudRoleEntity> getRolesByAdminId(Integer adminId);
}

