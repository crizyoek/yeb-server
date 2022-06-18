package com.example.server.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
@Data
@TableName("cloud_department")
public class CloudDepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 父id
	 */
	private Integer parentId;
	/**
	 * 路径
	 */
	private String depPath;
	/**
	 * 是否启用
	 */
	private Integer enabled;
	/**
	 * 是否上级
	 */
	private Integer isParent;

}
