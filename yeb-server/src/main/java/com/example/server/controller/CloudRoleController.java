package com.example.server.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.*;
import com.example.server.service.CloudAdminRoleService;
import com.example.server.service.CloudMenuRoleService;
import com.example.server.service.CloudMenuService;
import com.example.server.service.CloudRoleService;
import com.example.server.utils.PageUtils;
import com.example.server.utils.R;
import com.example.server.vo.req.role.SaveRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author crizyoek
 * @email sunlightcs@gmail.com
 * @date 2021-12-14 15:32:03
 */
@RestController
@RequestMapping("/system/basic/role")
public class CloudRoleController {
    @Autowired
    private CloudRoleService cloudRoleService;
    @Autowired
    private CloudAdminRoleService cloudAdminRoleService;
    @Autowired
    private CloudMenuRoleService cloudMenuRoleService;
    @Autowired
    private CloudMenuService cloudMenuService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public RespBean list(@RequestParam Map<String, Object> params) {
        PageUtils page = cloudRoleService.queryPage(params);

        return RespBean.success("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public RespBean info(@PathVariable("id") Integer id) {
        CloudRoleEntity cloudRole = cloudRoleService.getById(id);

        return RespBean.success("cloudRole", cloudRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public RespBean save(@RequestBody SaveRole cloudRole) {
        CloudRoleEntity cloudRoleEntity = new CloudRoleEntity();
        BeanUtils.copyProperties(cloudRole, cloudRoleEntity);
        cloudRoleService.save(cloudRoleEntity);

        return RespBean.success("新增成功");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public RespBean update(@RequestBody CloudRoleEntity cloudRole) {
        List<CloudRoleEntity> cloudRoleEntities = cloudRoleService.list(new LambdaQueryWrapper<CloudRoleEntity>().eq(CloudRoleEntity::getId, cloudRole.getId()));
        if (CollectionUtils.isEmpty(cloudRoleEntities)) {
            return RespBean.error("没有维护该职称信息或该职位信息已被删除");
        }
        cloudRoleService.updateById(cloudRole);

        return RespBean.success("更新成功");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public RespBean delete(@RequestBody Integer[] ids) {
        //判断他是不是被员工表关联了
        List<CloudAdminRoleEntity> cloudEmployeeEntities = cloudAdminRoleService.list(new LambdaQueryWrapper<CloudAdminRoleEntity>()
                .in(CloudAdminRoleEntity::getRid, Arrays.asList(ids)));
        List<CloudMenuRoleEntity> cloudMenuRoleEntities = cloudMenuRoleService.list(new LambdaQueryWrapper<CloudMenuRoleEntity>().in(CloudMenuRoleEntity::getRid, Arrays.asList(ids)));
        if (!CollectionUtils.isEmpty(cloudEmployeeEntities) && !CollectionUtils.isEmpty(cloudMenuRoleEntities)) {
            return RespBean.error("该职位还有关联信息，不容许删除");
        }
        cloudRoleService.removeByIds(Arrays.asList(ids));

        return RespBean.success("删除成功");
    }

    @GetMapping("/menus")
    public RespBean getMenusByRid() {
        return RespBean.success("page", cloudMenuService.getMenusWithRole());
    }
}
