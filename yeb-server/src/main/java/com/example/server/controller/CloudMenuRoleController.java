package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudMenuRoleEntity;
import com.example.server.service.CloudMenuRoleService;
import com.example.server.utils.PageUtils;
import com.example.server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@RestController
@RequestMapping("product/cloudmenurole")
public class CloudMenuRoleController {
    @Autowired
    private CloudMenuRoleService cloudMenuRoleService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudMenuRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudMenuRoleEntity cloudMenuRole = cloudMenuRoleService.getById(id);

        return R.ok().put("cloudMenuRole", cloudMenuRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudMenuRoleEntity cloudMenuRole){
		cloudMenuRoleService.save(cloudMenuRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudMenuRoleEntity cloudMenuRole){
		cloudMenuRoleService.updateById(cloudMenuRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudMenuRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
