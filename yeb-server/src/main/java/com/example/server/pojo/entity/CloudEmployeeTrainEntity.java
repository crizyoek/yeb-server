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
@TableName("cloud_employee_train")
public class CloudEmployeeTrainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 员工编号
	 */
	private Integer eid;
	/**
	 * 培训日期
	 */
	private Date traindate;
	/**
	 * 培训内容
	 */
	private String traincontent;
	/**
	 * 备注
	 */
	private String remark;

}
