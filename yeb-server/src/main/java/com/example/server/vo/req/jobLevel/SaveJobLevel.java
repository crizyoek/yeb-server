package com.example.server.vo.req.jobLevel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaveJobLevel {

    @ApiModelProperty(value = "职称名称",required = true)
    private String name;

    @ApiModelProperty(value = "职称等级",required = true)
    private String titleLevel;

    @ApiModelProperty(value = "是否启用",required = true)
    private Integer enabled;

    @ApiModelProperty(value = "是否删除",required = true)
    private Integer isDelete;
}
