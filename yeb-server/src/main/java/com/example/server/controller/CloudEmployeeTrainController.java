package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudEmployeeTrainEntity;
import com.example.server.service.CloudEmployeeTrainService;
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
@RequestMapping("product/cloudemployeetrain")
public class CloudEmployeeTrainController {
    @Autowired
    private CloudEmployeeTrainService cloudEmployeeTrainService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudEmployeeTrainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudEmployeeTrainEntity cloudEmployeeTrain = cloudEmployeeTrainService.getById(id);

        return R.ok().put("cloudEmployeeTrain", cloudEmployeeTrain);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudEmployeeTrainEntity cloudEmployeeTrain){
		cloudEmployeeTrainService.save(cloudEmployeeTrain);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudEmployeeTrainEntity cloudEmployeeTrain){
		cloudEmployeeTrainService.updateById(cloudEmployeeTrain);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudEmployeeTrainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
