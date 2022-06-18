package com.example.server.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
@Data
@TableName("cloud_admin_role")
public class CloudAdminRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer adminId;
	/**
	 * 权限id
	 */
	private Integer rid;

}
