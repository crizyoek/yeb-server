package com.example.server.vo.req.emp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SearchListParams {
    @ApiModelProperty(value = "运动员姓名")
    private String athleteName;
    @ApiModelProperty(value = "运动员性别")
    private String athleteGender;
    @ApiModelProperty(value = "运动员年龄")
    private String athleteAge;
    @ApiModelProperty(value = "运动员所属组织")
    private String athleteOrganization;
    @ApiModelProperty(value = "当前页码")
    private Integer page;
    @ApiModelProperty(value = "当前大小")
    private Integer size;
}
