package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudEmployeeRemoveEntity;
import com.example.server.service.CloudEmployeeRemoveService;
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
@RequestMapping("product/cloudemployeeremove")
public class CloudEmployeeRemoveController {
    @Autowired
    private CloudEmployeeRemoveService cloudEmployeeRemoveService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudEmployeeRemoveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudEmployeeRemoveEntity cloudEmployeeRemove = cloudEmployeeRemoveService.getById(id);

        return R.ok().put("cloudEmployeeRemove", cloudEmployeeRemove);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudEmployeeRemoveEntity cloudEmployeeRemove){
		cloudEmployeeRemoveService.save(cloudEmployeeRemove);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudEmployeeRemoveEntity cloudEmployeeRemove){
		cloudEmployeeRemoveService.updateById(cloudEmployeeRemove);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudEmployeeRemoveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
