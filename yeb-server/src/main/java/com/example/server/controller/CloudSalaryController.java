package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudSalaryEntity;
import com.example.server.service.CloudSalaryService;
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
@RequestMapping("product/cloudsalary")
public class CloudSalaryController {
    @Autowired
    private CloudSalaryService cloudSalaryService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudSalaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudSalaryEntity cloudSalary = cloudSalaryService.getById(id);

        return R.ok().put("cloudSalary", cloudSalary);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudSalaryEntity cloudSalary){
		cloudSalaryService.save(cloudSalary);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudSalaryEntity cloudSalary){
		cloudSalaryService.updateById(cloudSalary);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudSalaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
