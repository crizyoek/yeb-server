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
 * @date 2021-12-14 15:32:03
 */
@Data
@TableName("cloud_mail_log")
public class CloudMailLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 消息id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private String msgid;
	/**
	 * 接收员工id
	 */
	private Integer eid;
	/**
	 * 状态（0:消息投递中 1:投递成功 2:投递失败）
	 */
	private Integer status;
	/**
	 * 路由键
	 */
	private String routekey;
	/**
	 * 交换机
	 */
	private String exchange;
	/**
	 * 重试次数
	 */
	private Integer count;
	/**
	 * 重试时间
	 */
	private Date trytime;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;

}
