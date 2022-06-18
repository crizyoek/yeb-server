package com.example.server.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.server.pojo.entity.CloudSysMsgContentEntity;
import com.example.server.service.CloudSysMsgContentService;
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
@RequestMapping("product/cloudsysmsgcontent")
public class CloudSysMsgContentController {
    @Autowired
    private CloudSysMsgContentService cloudSysMsgContentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cloudSysMsgContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CloudSysMsgContentEntity cloudSysMsgContent = cloudSysMsgContentService.getById(id);

        return R.ok().put("cloudSysMsgContent", cloudSysMsgContent);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudSysMsgContentEntity cloudSysMsgContent){
		cloudSysMsgContentService.save(cloudSysMsgContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudSysMsgContentEntity cloudSysMsgContent){
		cloudSysMsgContentService.updateById(cloudSysMsgContent);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		cloudSysMsgContentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
