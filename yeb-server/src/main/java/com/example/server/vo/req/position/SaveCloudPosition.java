package com.example.server.vo.req.position;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 职位保存入参
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaveCloudPosition {
    @ApiModelProperty(value = "职位名称",required = true)
    private String name;
    @ApiModelProperty(value = "是否启用",required = true)
    private String enabled;
}
