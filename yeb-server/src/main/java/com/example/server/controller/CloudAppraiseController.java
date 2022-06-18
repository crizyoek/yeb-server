package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudAppraiseEntity;
import com.example.server.service.CloudAppraiseService;
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
@RequestMapping("product/cloudappraise")
public class CloudAppraiseController {
    @Autowired
    private CloudAppraiseService cloudAppraiseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudAppraiseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudAppraiseEntity cloudAppraise = cloudAppraiseService.getById(id);

        return R.ok().put("cloudAppraise", cloudAppraise);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudAppraiseEntity cloudAppraise){
		cloudAppraiseService.save(cloudAppraise);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudAppraiseEntity cloudAppraise){
		cloudAppraiseService.updateById(cloudAppraise);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudAppraiseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
