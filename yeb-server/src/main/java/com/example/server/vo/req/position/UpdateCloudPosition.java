package com.example.server.vo.req.position;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 更新职位信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UpdateCloudPosition {
    @ApiModelProperty(value = "id",required = true)
    private Integer id;
    @ApiModelProperty(value = "职位名称",required = true)
    private String name;
    @ApiModelProperty(value = "是否启用",required = true)
    private Integer enabled;
    @ApiModelProperty(value = "是否删除",required = true)
    private Integer delete;
}
