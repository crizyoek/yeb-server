package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.server.common.RespBean;
import com.example.server.config.jwt.JwtTokenUtil;
import com.example.server.pojo.entity.CloudAdminRoleEntity;
import com.example.server.pojo.entity.CloudRoleEntity;
import com.example.server.service.CloudAdminRoleService;
import com.example.server.service.CloudRoleService;
import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudAdminDao;
import com.example.server.pojo.entity.CloudAdminEntity;
import com.example.server.service.CloudAdminService;
import com.example.server.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author Administrator
 */
@Service("cloudAdminService")
public class CloudAdminServiceImpl extends ServiceImpl<CloudAdminDao, CloudAdminEntity> implements CloudAdminService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CloudRoleService cloudRoleService;
    @Autowired
    private CloudAdminRoleService cloudAdminRoleService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudAdminEntity> page = this.page(
                new Query<CloudAdminEntity>().getPage(params),
                new QueryWrapper<CloudAdminEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 登录之后返回token
     *
     * @param username
     * @param password
     * @param code
     * @param httpServletRequest
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest httpServletRequest) {
        //从session里面拿到验证码
        String captcha = (String) httpServletRequest.getSession().getAttribute("captcha");
        if (StringUtils.isBlank(code) || !captcha.equalsIgnoreCase(code)) {
            return RespBean.error("验证码输入错误");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被冻结，请联系管理员！");
        }
        //更新用户登录对象到security的全局里
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    @Override
    public CloudAdminEntity getAdminByUserName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<CloudAdminEntity>()
                .eq(CloudAdminEntity::getUsername, username)
                .eq(CloudAdminEntity::getEnabled, true));

    }

    @Override
    public List<CloudRoleEntity> getRolesByAdminId(Integer adminId) {
        List<CloudAdminRoleEntity> cloudAdminRoleEntityList = cloudAdminRoleService.getAdminRoleList(adminId);
        return cloudRoleService.list(new LambdaQueryWrapper<CloudRoleEntity>()
                .in(!CollectionUtils.isEmpty(cloudAdminRoleEntityList), CloudRoleEntity::getId,
                        cloudAdminRoleEntityList.stream()
                        .map(CloudAdminRoleEntity::getRid).collect(Collectors.toList())));
    }

}