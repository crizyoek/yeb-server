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
@TableName("cloud_appraise")
public class CloudAppraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 员工id
	 */
	private Integer eid;
	/**
	 * 考评日期
	 */
	private Date appdate;
	/**
	 * 考评结果
	 */
	private String appresult;
	/**
	 * 考评内容
	 */
	private String appcontent;
	/**
	 * 备注
	 */
	private String remark;

}
