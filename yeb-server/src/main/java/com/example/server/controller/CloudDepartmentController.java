package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudDepartmentEntity;
import com.example.server.service.CloudDepartmentService;
import com.example.server.utils.PageUtils;
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
@RequestMapping("system/basic/department")
public class CloudDepartmentController {
    @Autowired
    private CloudDepartmentService cloudDepartmentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public RespBean list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudDepartmentService.queryPage(params);

        return RespBean.success("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public RespBean info(@PathVariable("id") Integer id){
		CloudDepartmentEntity cloudDepartment = cloudDepartmentService.getById(id);

        return RespBean.success("cloudDepartment", cloudDepartment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public RespBean save(@RequestBody CloudDepartmentEntity cloudDepartment){
		cloudDepartmentService.save(cloudDepartment);
        return RespBean.success("保存成功");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public RespBean update(@RequestBody CloudDepartmentEntity cloudDepartment){
		cloudDepartmentService.updateById(cloudDepartment);

        return RespBean.success("更新成功");
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    public RespBean delete(@PathVariable("id") Integer[] ids){
		cloudDepartmentService.removeByIds(Arrays.asList(ids));

        return RespBean.success("");
    }

}
