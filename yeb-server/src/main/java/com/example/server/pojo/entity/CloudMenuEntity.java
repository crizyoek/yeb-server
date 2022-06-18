package com.example.server.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@Data
@TableName("cloud_menu")
public class CloudMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * url
	 */
	private String url;
	/**
	 * path
	 */
	private String path;
	/**
	 * 组件
	 */
	private String component;
	/**
	 * 菜单名
	 */
	private String name;
	/**
	 * 图标
	 */
	private String iconCls;
	/**
	 * 是否保持激活
	 */
	private Integer keepAlive;
	/**
	 * 是否要求权限
	 */
	private Integer requireAuth;
	/**
	 * 父id
	 */
	private Integer parentId;
	/**
	 * 是否启用
	 */
	private Integer enabled;

	/**
	 * 角色实体
	 */
	@TableField(exist = false)//表里是不存在的
	private List<CloudRoleEntity> roles;

	/**
	 * 子菜单
	 */
	@TableField(exist = false)//表里是不存在的
	private List<CloudMenuEntity> children;

}
