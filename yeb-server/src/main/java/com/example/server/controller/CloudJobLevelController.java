package com.example.server.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.pojo.entity.CloudJobLevelEntity;
import com.example.server.service.CloudEmployeeService;
import com.example.server.service.CloudJobLevelService;
import com.example.server.utils.PageUtils;
import com.example.server.vo.req.jobLevel.SaveJobLevel;
import com.example.server.vo.req.jobLevel.UpdateJobLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class CloudJobLevelController {
    @Autowired
    private CloudJobLevelService cloudJobLevelService;
    @Autowired
    private CloudEmployeeService cloudEmployeeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public RespBean list(@RequestParam Map<String, Object> params) {
        PageUtils page = cloudJobLevelService.queryPage(params);

        return RespBean.success("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public RespBean info(@PathVariable("id") Integer id) {
        CloudJobLevelEntity cloudJobLevel = cloudJobLevelService.getById(id);

        return RespBean.success("cloudJobLevel", cloudJobLevel);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public RespBean save(@RequestBody SaveJobLevel saveJobLevel) {
        CloudJobLevelEntity cloudJobLevel = new CloudJobLevelEntity();
        BeanUtils.copyProperties(saveJobLevel, cloudJobLevel);
        cloudJobLevelService.save(cloudJobLevel);

        return RespBean.success("保存成功");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public RespBean update(@RequestBody UpdateJobLevel updateJobLevel) {
        CloudJobLevelEntity cloudJobLevel = new CloudJobLevelEntity();
        BeanUtils.copyProperties(updateJobLevel, cloudJobLevel);
        List<CloudJobLevelEntity> cloudJobLevelEntities = cloudJobLevelService.list(
                new LambdaQueryWrapper<CloudJobLevelEntity>().eq(CloudJobLevelEntity::getId, updateJobLevel.getId()));
        if(CollectionUtils.isEmpty(cloudJobLevelEntities)){
            return RespBean.error("没有维护该职称信息或该职位信息已被删除");
        }
        cloudJobLevelService.updateById(cloudJobLevel);

        return RespBean.success("修改成功");
    }

    /**
     * 删除     在设置mybatis的逻辑删除之后，再次更新数据库该字段则不起作用
     */
    @PostMapping("/delete")
    public RespBean delete(@RequestBody Integer[] ids) {
        //判断他是不是被员工表关联了
        List<CloudEmployeeEntity> cloudEmployeeEntities = cloudEmployeeService.list(new LambdaQueryWrapper<CloudEmployeeEntity>()
                .in(CloudEmployeeEntity::getJobLevelId, Arrays.asList(ids)));
        if (!CollectionUtils.isEmpty(cloudEmployeeEntities)) {
            return RespBean.error("该职位还有关联信息，不容许删除");
        }
        cloudJobLevelService.removeByIds(Arrays.asList(ids));

        return RespBean.success("删除成功");
    }

}
