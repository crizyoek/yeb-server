package com.example.server.controller;

import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudAdminEntity;
import com.example.server.vo.req.LoginParams;
import com.example.server.service.CloudAdminService;
import com.example.server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class LoginController
{
	@Autowired
	private CloudAdminService cloudAdminService ;

	@PostMapping("/login")
	public RespBean login(@RequestBody LoginParams loginParams,HttpServletRequest httpServletRequest){
		return cloudAdminService.login(loginParams.getUsername(),loginParams.getPassword(),loginParams.getCaptcha(),httpServletRequest);
	}

	/**
	 * 获取当前用户登录的信息
	 * @param principal
	 * @return
	 */
	@GetMapping("/admin/info")
	public CloudAdminEntity getAdminInfo(Principal principal){
		if(null==principal){
			return null;
		}
		String username=principal.getName();
		CloudAdminEntity adminEntity = cloudAdminService.getAdminByUserName(username);
		adminEntity.setPassword(null);
		adminEntity.setRoles(cloudAdminService.getRolesByAdminId(adminEntity.getId()));
		return adminEntity;
	}

	@PostMapping("/logout")
	public R logout(){
		//这里后端不需要进行删除token，由前端删除TOKen
		return R.ok(200,"注销成功");
	}

}
