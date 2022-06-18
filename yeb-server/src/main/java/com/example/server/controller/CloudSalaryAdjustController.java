package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudSalaryAdjustEntity;
import com.example.server.service.CloudSalaryAdjustService;
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
@RequestMapping("product/cloudsalaryadjust")
public class CloudSalaryAdjustController {
    @Autowired
    private CloudSalaryAdjustService cloudSalaryAdjustService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudSalaryAdjustService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudSalaryAdjustEntity cloudSalaryAdjust = cloudSalaryAdjustService.getById(id);

        return R.ok().put("cloudSalaryAdjust", cloudSalaryAdjust);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudSalaryAdjustEntity cloudSalaryAdjust){
		cloudSalaryAdjustService.save(cloudSalaryAdjust);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudSalaryAdjustEntity cloudSalaryAdjust){
		cloudSalaryAdjustService.updateById(cloudSalaryAdjust);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudSalaryAdjustService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
