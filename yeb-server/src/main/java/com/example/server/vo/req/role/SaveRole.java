package com.example.server.vo.req.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SaveRole {
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称",required = true)
    private String name;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称",required = true)
    private String namezh;

}
