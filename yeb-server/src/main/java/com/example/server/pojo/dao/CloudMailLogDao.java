package com.example.server.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.entity.CloudMailLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@Mapper
public interface CloudMailLogDao extends BaseMapper<CloudMailLogEntity> {
	
}
