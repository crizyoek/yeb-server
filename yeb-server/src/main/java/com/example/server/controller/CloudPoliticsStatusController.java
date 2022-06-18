package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudPoliticsStatusEntity;
import com.example.server.service.CloudPoliticsStatusService;
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
@RequestMapping("product/cloudpoliticsstatus")
public class CloudPoliticsStatusController {
    @Autowired
    private CloudPoliticsStatusService cloudPoliticsStatusService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudPoliticsStatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudPoliticsStatusEntity cloudPoliticsStatus = cloudPoliticsStatusService.getById(id);

        return R.ok().put("cloudPoliticsStatus", cloudPoliticsStatus);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudPoliticsStatusEntity cloudPoliticsStatus){
		cloudPoliticsStatusService.save(cloudPoliticsStatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudPoliticsStatusEntity cloudPoliticsStatus){
		cloudPoliticsStatusService.updateById(cloudPoliticsStatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudPoliticsStatusService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
