package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudEmployeeEcEntity;
import com.example.server.service.CloudEmployeeEcService;
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
@RequestMapping("product/cloudemployeeec")
public class CloudEmployeeEcController {
    @Autowired
    private CloudEmployeeEcService cloudEmployeeEcService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudEmployeeEcService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudEmployeeEcEntity cloudEmployeeEc = cloudEmployeeEcService.getById(id);

        return R.ok().put("cloudEmployeeEc", cloudEmployeeEc);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudEmployeeEcEntity cloudEmployeeEc){
		cloudEmployeeEcService.save(cloudEmployeeEc);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudEmployeeEcEntity cloudEmployeeEc){
		cloudEmployeeEcService.updateById(cloudEmployeeEc);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudEmployeeEcService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
