package com.example.server.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@Data
@TableName("cloud_position")
public class CloudPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 职位
	 */
	private String name;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)//插入时填充
	private Date createDate;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.UPDATE)//修改时填充
	private Date updateDate;
	/**
	 * 是否启用
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)//默认启用
	private Integer enabled;
	/**
	 * 是否删除
	 */
	@TableLogic(value = "0", delval = "1")//逻辑删除标识 value的值表示未删除的时候的值，delval的值表示已删除时候的值；
	@TableField(fill = FieldFill.INSERT_UPDATE)//配置deleteFlag字段的自动填充规则
	private Integer isDeleted;

}
