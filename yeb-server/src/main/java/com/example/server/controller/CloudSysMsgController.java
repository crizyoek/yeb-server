package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudSysMsgEntity;
import com.example.server.service.CloudSysMsgService;
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
@RequestMapping("product/cloudsysmsg")
public class CloudSysMsgController {
    @Autowired
    private CloudSysMsgService cloudSysMsgService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudSysMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudSysMsgEntity cloudSysMsg = cloudSysMsgService.getById(id);

        return R.ok().put("cloudSysMsg", cloudSysMsg);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudSysMsgEntity cloudSysMsg){
		cloudSysMsgService.save(cloudSysMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudSysMsgEntity cloudSysMsg){
		cloudSysMsgService.updateById(cloudSysMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudSysMsgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
