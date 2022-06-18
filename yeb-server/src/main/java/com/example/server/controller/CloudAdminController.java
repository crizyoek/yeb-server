package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudAdminEntity;
import com.example.server.service.CloudAdminService;
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
@RequestMapping("product/cloudadmin")
public class CloudAdminController {
    @Autowired
    private CloudAdminService cloudAdminService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudAdminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudAdminEntity cloudAdmin = cloudAdminService.getById(id);

        return R.ok().put("cloudAdmin", cloudAdmin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudAdminEntity cloudAdmin){
		cloudAdminService.save(cloudAdmin);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudAdminEntity cloudAdmin){
		cloudAdminService.updateById(cloudAdmin);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudAdminService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
