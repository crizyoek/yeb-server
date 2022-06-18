package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudAdminRoleEntity;
import com.example.server.service.CloudAdminRoleService;
import com.example.server.utils.PageUtils;
import com.example.server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
@RestController
@RequestMapping("product/cloudadminrole")
public class CloudAdminRoleController {
    @Autowired
    private CloudAdminRoleService cloudAdminRoleService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudAdminRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudAdminRoleEntity cloudAdminRole = cloudAdminRoleService.getById(id);

        return R.ok().put("cloudAdminRole", cloudAdminRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudAdminRoleEntity cloudAdminRole){
		cloudAdminRoleService.save(cloudAdminRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudAdminRoleEntity cloudAdminRole){
		cloudAdminRoleService.updateById(cloudAdminRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudAdminRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
