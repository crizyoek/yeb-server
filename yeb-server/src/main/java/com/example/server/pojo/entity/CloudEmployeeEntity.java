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
@TableName("cloud_employee")
public class CloudEmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 员工姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 婚姻状况
	 */
	private String wedlock;
	/**
	 * 民族
	 */
	private Integer nationId;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 政治面貌
	 */
	private Integer politicId;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 所属部门
	 */
	private Integer departmentId;
	/**
	 * 职称ID
	 */
	private Integer jobLevelId;
	/**
	 * 职位ID
	 */
	private Integer posId;
	/**
	 * 聘用形式
	 */
	private String engageForm;
	/**
	 * 最高学历
	 */
	private String tipTopDegree;
	/**
	 * 所属专业
	 */
	private String specialty;
	/**
	 * 毕业院校
	 */
	private String school;
	/**
	 * 入职日期
	 */
	private Date beginDate;
	/**
	 * 在职状态
	 */
	private String  workState;
	/**
	 * 工号
	 */
	private String workId;
	/**
	 * 合同期限
	 */
	private Double contractTerm;
	/**
	 * 转正日期
	 */
	private Date conversionTime;
	/**
	 * 离职日期
	 */
	private Date notworkDate;
	/**
	 * 合同起始日期
	 */
	private Date beginContract;
	/**
	 * 合同终止日期
	 */
	private Date endContract;
	/**
	 * 工龄
	 */
	private Integer workAge;
	/**
	 * 工资账套ID
	 */
	private Integer salaryId;

}
