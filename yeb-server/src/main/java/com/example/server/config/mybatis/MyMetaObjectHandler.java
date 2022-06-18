package com.example.server.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATE_TIME = "createDate";
    private static final String UPDATE_TIME = "updateDate";
    private static final String IS_DELETE = "isDeleted";
    private static final String ENABLED= "enabled";
    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填入创建时间
        if (metaObject.hasGetter(CREATE_TIME)) {
            this.fillStrategy(metaObject, CREATE_TIME, new Date());
        }

        // 自动填入更新时间
        if (metaObject.hasGetter(UPDATE_TIME)) {
            this.fillStrategy(metaObject, UPDATE_TIME, new Date());
        }

        //自动填入是否被删除 1 被删除 0 未删除
        if (metaObject.hasGetter(IS_DELETE)) {
            this.strictInsertFill(metaObject, IS_DELETE, Integer.class,0);
        }

        //自动填入是否被启用 1 默认启用 0 默认禁用
        if (metaObject.hasGetter(ENABLED)) {
            this.strictInsertFill(metaObject, ENABLED, Integer.class,1);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填入更新时间
        if (metaObject.hasGetter(UPDATE_TIME)) {
            this.fillStrategy(metaObject, UPDATE_TIME, new Date());
        }

        //自动填入是否被删除 1 被删除 0 未删除
        if (metaObject.hasGetter(IS_DELETE)) {
            this.strictInsertFill(metaObject, IS_DELETE, Integer.class,0);
        }

        //自动填入是否被启用 1 默认启用 0 默认禁用
        if (metaObject.hasGetter(ENABLED)) {
            this.strictInsertFill(metaObject, ENABLED, Integer.class,1);
        }
    }
}
