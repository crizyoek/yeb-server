package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudOplogEntity;
import com.example.server.service.CloudOplogService;
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
@RequestMapping("product/cloudoplog")
public class CloudOplogController {
    @Autowired
    private CloudOplogService cloudOplogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudOplogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudOplogEntity cloudOplog = cloudOplogService.getById(id);

        return R.ok().put("cloudOplog", cloudOplog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudOplogEntity cloudOplog){
		cloudOplogService.save(cloudOplog);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudOplogEntity cloudOplog){
		cloudOplogService.updateById(cloudOplog);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudOplogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
