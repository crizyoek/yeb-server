package com.example.server.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudEmployeeEntity;
import com.example.server.pojo.entity.CloudPositionEntity;
import com.example.server.service.CloudEmployeeService;
import com.example.server.service.CloudPositionService;
import com.example.server.utils.PageUtils;
import com.example.server.vo.req.position.SaveCloudPosition;
import com.example.server.vo.req.position.UpdateCloudPosition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@RestController
@RequestMapping("/system/basic/pos")
public class CloudPositionController {
    @Autowired
    private CloudPositionService cloudPositionService;
    @Autowired
    private CloudEmployeeService cloudEmployeeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public RespBean list(@RequestParam Map<String, Object> params) {
        PageUtils page = cloudPositionService.queryPage(params);
        return RespBean.success("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public RespBean info(@PathVariable("id") Integer id) {
        CloudPositionEntity cloudPosition = cloudPositionService.getById(id);
        return null == cloudPosition ? RespBean.error("该职位已被删除或还未维护,请先维护！") :
                RespBean.success("查询信息成功！", cloudPosition);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public RespBean save(@RequestBody SaveCloudPosition cloudPosition) {
        CloudPositionEntity cloudPositionEntity = new CloudPositionEntity();
        BeanUtils.copyProperties(cloudPosition, cloudPositionEntity);
        cloudPositionService.save(cloudPositionEntity);
        return RespBean.success("保存成功！");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public RespBean update(@RequestBody UpdateCloudPosition cloudPosition) {
        List<CloudPositionEntity> cloudPositionEntities = cloudPositionService.list(new LambdaQueryWrapper<CloudPositionEntity>()
                .eq(CloudPositionEntity::getId, cloudPosition.getId()));
        if (CollectionUtils.isEmpty(cloudPositionEntities)) {
            return RespBean.error("该职位已被删除或还未维护，请先维护！");
        }
        CloudPositionEntity cloudPositionEntity = new CloudPositionEntity();
        BeanUtils.copyProperties(cloudPosition, cloudPositionEntity);
        cloudPositionService.updateById(cloudPositionEntity);

        return RespBean.success("更新成功！");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public RespBean delete(@RequestBody Integer[] ids) {
        //判断他是不是被员工表关联了
        List<CloudEmployeeEntity> cloudEmployeeEntities = cloudEmployeeService.list(new LambdaQueryWrapper<CloudEmployeeEntity>()
                .in(CloudEmployeeEntity::getPosId, Arrays.asList(ids)));
        if(!CollectionUtils.isEmpty(cloudEmployeeEntities)){
            return RespBean.error("该职位还有关联信息，不容许删除");
        }
        cloudPositionService.getBaseMapper().deleteBatchIds(Arrays.asList(ids));
        return RespBean.success("删除成功");
    }

}
