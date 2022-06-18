package com.example.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.service.CloudEmployeeService;
import com.example.server.utils.R;
import com.example.server.vo.req.emp.SearchListParams;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:04
 */
@RestController
@RequestMapping("/athletes")
public class CloudEmployeeController {
    @Autowired
    private CloudEmployeeService cloudEmployeeService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public R list(@RequestBody SearchListParams searchListParams,
                  @RequestParam(required = true,defaultValue = "1",value = "page" ) Integer page,
                  @RequestParam(required = true,defaultValue = "5",value = "size") Integer size) {
        Page pageInfo = new Page<>().setCurrent(page).setSize(size);
        LambdaQueryWrapper<CloudEmployeeEntity> wrapper = getWrapper(searchListParams);
        pageInfo = cloudEmployeeService.queryPage(pageInfo, wrapper);
        return R.ok().put("obj", pageInfo);
    }

    private LambdaQueryWrapper<CloudEmployeeEntity> getWrapper(SearchListParams searchListParams) {
        return new LambdaQueryWrapper<CloudEmployeeEntity>()
                .eq(StringUtils.isNotEmpty(searchListParams.getAthleteName()), CloudEmployeeEntity::getName, searchListParams.getAthleteName())
                .eq(StringUtils.isNotEmpty(searchListParams.getAthleteAge()), CloudEmployeeEntity::getWorkAge, searchListParams.getAthleteAge())
                .eq(StringUtils.isNotEmpty(searchListParams.getAthleteGender()), CloudEmployeeEntity::getGender, searchListParams.getAthleteGender())
                .eq(StringUtils.isNotEmpty(searchListParams.getAthleteOrganization()), CloudEmployeeEntity::getDepartmentId, searchListParams.getAthleteOrganization());
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        CloudEmployeeEntity cloudEmployee = cloudEmployeeService.getById(id);

        return R.ok().put("obj", cloudEmployee);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CloudEmployeeEntity cloudEmployee) {
        cloudEmployeeService.save(cloudEmployee);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CloudEmployeeEntity cloudEmployee) {
        cloudEmployeeService.updateById(cloudEmployee);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        cloudEmployeeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
