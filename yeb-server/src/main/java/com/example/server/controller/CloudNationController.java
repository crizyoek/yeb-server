package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudNationEntity;
import com.example.server.service.CloudNationService;
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
@RequestMapping("product/cloudnation")
public class CloudNationController {
    @Autowired
    private CloudNationService cloudNationService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudNationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudNationEntity cloudNation = cloudNationService.getById(id);

        return R.ok().put("cloudNation", cloudNation);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudNationEntity cloudNation){
		cloudNationService.save(cloudNation);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudNationEntity cloudNation){
		cloudNationService.updateById(cloudNation);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudNationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
