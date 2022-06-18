package com.example.server.config.filter;

import com.example.server.pojo.entity.CloudMenuEntity;
import com.example.server.pojo.entity.CloudRoleEntity;
import com.example.server.service.CloudMenuService;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限控制
 * 根据请求url分析出请求所需角色
 *
 * @author zhanglishen
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private CloudMenuService menuService;

	AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
		//获取请求的url
		String requestUrl = ((FilterInvocation)o).getRequestUrl();
		//System.out.println("requestUrl = " + requestUrl);
		//获取菜单
		List<CloudMenuEntity> menus = menuService.getMenusWithRole();
		//System.out.println("menus = " + menus);
		for (CloudMenuEntity menu : menus) {
			//判断请求的url与菜单角色是否匹配
			if (antPathMatcher.match(menu.getUrl(),requestUrl)){
				//System.out.println("menu = " + menu.getUrl());
				String[] str = menu.getRoles().stream().map(CloudRoleEntity ::getName).toArray(String[]::new);
				//System.out.println("str = " + str);
				return SecurityConfig.createList(str);
			}
		}
		//没匹配的url默认为登录即可访问
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
