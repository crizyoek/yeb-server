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
@TableName("cloud_employee_remove")
public class CloudEmployeeRemoveEntity implements Serializable {
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
	 * 调动后部门
	 */
	private Integer afterdepid;
	/**
	 * 调动后职位
	 */
	private Integer afterjobid;
	/**
	 * 调动日期
	 */
	private Date removedate;
	/**
	 * 调动原因
	 */
	private String reason;
	/**
	 * 备注
	 */
	private String remark;

}
