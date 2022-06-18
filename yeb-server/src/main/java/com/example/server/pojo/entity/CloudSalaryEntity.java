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
@TableName("cloud_salary")
public class CloudSalaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 基本工资
	 */
	private Integer basicsalary;
	/**
	 * 奖金
	 */
	private Integer bonus;
	/**
	 * 午餐补助
	 */
	private Integer lunchsalary;
	/**
	 * 交通补助
	 */
	private Integer trafficsalary;
	/**
	 * 应发工资
	 */
	private Integer allsalary;
	/**
	 * 养老金基数
	 */
	private Integer pensionbase;
	/**
	 * 养老金比率
	 */
	private Float pensionper;
	/**
	 * 启用时间
	 */
	private Date createdate;
	/**
	 * 医疗基数
	 */
	private Integer medicalbase;
	/**
	 * 医疗保险比率
	 */
	private Float medicalper;
	/**
	 * 公积金基数
	 */
	private Integer accumulationfundbase;
	/**
	 * 公积金比率
	 */
	private Float accumulationfundper;
	/**
	 * 名称
	 */
	private String name;

}
