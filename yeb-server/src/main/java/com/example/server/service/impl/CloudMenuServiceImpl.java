package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.server.common.RespBean;
import com.example.server.pojo.entity.CloudAdminRoleEntity;
import com.example.server.pojo.entity.CloudMenuRoleEntity;
import com.example.server.pojo.entity.CloudRoleEntity;
import com.example.server.service.CloudAdminRoleService;
import com.example.server.service.CloudMenuRoleService;
import com.example.server.service.CloudRoleService;
import com.example.server.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.pojo.dao.CloudMenuDao;
import com.example.server.pojo.entity.CloudMenuEntity;
import com.example.server.service.CloudMenuService;
import com.example.server.utils.PageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("cloudMenuService")
public class CloudMenuServiceImpl extends ServiceImpl<CloudMenuDao, CloudMenuEntity> implements CloudMenuService {

    @Autowired
    private CloudMenuRoleService cloudMenuRoleService;
    @Autowired
    private CloudAdminRoleService cloudAdminRoleService;
    @Autowired
    private CloudRoleService cloudRoleService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CloudMenuEntity> page = this.page(
                new Query<CloudMenuEntity>().getPage(params),
                new QueryWrapper<CloudMenuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CloudMenuEntity> getMenusWithRole() {
        List<Integer> allRoleIds = cloudAdminRoleService.list().stream().map(CloudAdminRoleEntity::getRid).collect(Collectors.toList());
        //menuList是该用户的除一级级别菜单外的所有菜单
        List<CloudMenuRoleEntity> allRolesMenuList = cloudMenuRoleService.list(new LambdaQueryWrapper<CloudMenuRoleEntity>()
                .in(!CollectionUtils.isEmpty(allRoleIds), CloudMenuRoleEntity::getRid, allRoleIds));
        List<CloudMenuEntity> allMenuList = baseMapper.selectList(new LambdaQueryWrapper<CloudMenuEntity>().in(CloudMenuEntity::getId,
                allRolesMenuList.stream().map(CloudMenuRoleEntity::getMid).collect(Collectors.toList())));
        return allMenuList.stream().filter(e -> allRolesMenuList.stream().anyMatch(rm -> rm.getMid().equals(e.getId()))).map(e -> {
            List<Integer> roleIds = allRolesMenuList.stream().filter(rm -> rm.getMid().equals(e.getId())).map(CloudMenuRoleEntity::getRid).collect(Collectors.toList());
            List<CloudRoleEntity> roleEntityList = cloudRoleService.list(new LambdaQueryWrapper<CloudRoleEntity>().in(!CollectionUtils.isEmpty(roleIds), CloudRoleEntity::getId, roleIds));
            e.setRoles(roleEntityList);
            return e;
        }).collect(Collectors.toList());
    }

    @Override
    public RespBean getMenusByAdminId(Integer adminId) {
        /**
         * 知道管理员id，
         * 可以通过管理员id查出角色id，
         * 直接通过角色id获取到相关的菜单id，
         * 然后通过菜单id获取到菜单的详细数据
         */
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //查redis缓存
        List<CloudMenuEntity> cloudMenuEntityList = (List<CloudMenuEntity>) valueOperations.get("menu_" + adminId);
        if (CollectionUtils.isEmpty(cloudMenuEntityList)) {
            List<CloudAdminRoleEntity> adminRoleList =
                    cloudAdminRoleService.getAdminRoleList(adminId);

            cloudMenuEntityList =
                    getMenusWithRoleList(adminRoleList.stream().map(CloudAdminRoleEntity::getRid)
                            .collect(Collectors.toList()));

            valueOperations.set("menu_" + adminId, cloudMenuEntityList);
        }
        return RespBean.success("获取菜单成功", cloudMenuEntityList);
    }

    public List<CloudMenuEntity> getMenusWithRoleList(List<Integer> roleList) {
        //menuList是该用户的除一级级别菜单外的所有菜单
        List<Integer> menuList = cloudMenuRoleService.selectMenusWithRoleList(roleList);
        //查出一级菜单
        List<CloudMenuEntity> parentMenuList = baseMapper.selectList(new LambdaQueryWrapper<CloudMenuEntity>()
                .in(CloudMenuEntity::getParentId, 1).eq(CloudMenuEntity::getEnabled, true));
        //查出它的所有子菜单
        List<CloudMenuEntity> childrenMenuList = baseMapper.selectList(new LambdaQueryWrapper<CloudMenuEntity>()
                .in(CloudMenuEntity::getParentId, parentMenuList.stream().map(CloudMenuEntity::getId).collect(Collectors.toList()))
                .eq(CloudMenuEntity::getEnabled, true));
        if (CollectionUtils.isEmpty(childrenMenuList)) {
            return parentMenuList;
        }
        childrenMenuList = childrenMenuList.stream().filter(cMenu -> !menuList.stream().noneMatch(menu -> menu.equals(cMenu.getId()))).collect(Collectors.toList());
        return setChildrenMenuList(parentMenuList, childrenMenuList);
    }

    private List<CloudMenuEntity> setChildrenMenuList(List<CloudMenuEntity> parentMenuList, List<CloudMenuEntity> childrenMenuList) {
        return parentMenuList.stream().filter(parentMenu ->
                        //是不是含有子菜单
                        childrenMenuList.stream().anyMatch(childrenMenu -> parentMenu.getId().equals(childrenMenu.getParentId())))
                .map(parentMenu -> {
                    List<CloudMenuEntity> collect = childrenMenuList.stream().filter(childrenMenu -> parentMenu.getId().equals(childrenMenu.getParentId())).collect(Collectors.toList());
                    parentMenu.setChildren(collect);
                    setChildrenMenuList(collect, childrenMenuList);
                    return parentMenu;
                }).collect(Collectors.toList());
    }


}