package com.example.server.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 公共返回对象
 */
@Data
@AllArgsConstructor//将所有属性都构造
public class Result
{
	private boolean success;
	private int code;
	private String msg;
	private Object data;

	public static Result success(Object data) {
		return new Result(true, 200, "success", data);
	}

	public static Result fail(int code, String msg) {
		return new Result(false, code, msg, null);
	}
}
