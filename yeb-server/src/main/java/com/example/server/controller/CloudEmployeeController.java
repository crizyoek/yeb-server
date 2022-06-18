package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.service.CloudEmployeeService;
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
@RequestMapping("athletes")
public class CloudEmployeeController {
    @Autowired
    private CloudEmployeeService cloudEmployeeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudEmployeeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudEmployeeEntity cloudEmployee = cloudEmployeeService.getById(id);

        return R.ok().put("cloudEmployee", cloudEmployee);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudEmployeeEntity cloudEmployee){
		cloudEmployeeService.save(cloudEmployee);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudEmployeeEntity cloudEmployee){
		cloudEmployeeService.updateById(cloudEmployee);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudEmployeeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
