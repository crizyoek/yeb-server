package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudAdminEntity;
import com.example.server.pojo.entity.CloudMenuEntity;
import com.example.server.service.CloudMenuService;
import com.example.server.utils.PageUtils;
import com.example.server.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@RestController
@RequestMapping("/system/cfg")
public class CloudMenuController {
    @Autowired
    private CloudMenuService cloudMenuService;

    @ApiOperation("通过用户ID查询菜单列表")
    @GetMapping("/menu")
    public RespBean getMenusByAdminId(){
         return cloudMenuService.getMenusByAdminId(
                 ((CloudAdminEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
