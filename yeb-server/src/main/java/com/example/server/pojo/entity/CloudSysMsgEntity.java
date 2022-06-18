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
@TableName("cloud_sys_msg")
public class CloudSysMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 消息id
	 */
	private Integer mid;
	/**
	 * 0表示群发消息
	 */
	private Integer type;
	/**
	 * 这条消息是给谁的
	 */
	private Integer adminid;
	/**
	 * 0 未读 1 已读
	 */
	private Integer state;

}
