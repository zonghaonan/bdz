package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GwMenu对象", description="")
public class GwMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父菜单id")
    @NotNull(message = "父菜单不能为空")
    private Integer parentId;

    @ApiModelProperty(value = "菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    @ApiModelProperty(value = "菜单路径")
    private String path;

    @ApiModelProperty(value = "授权(多个用逗号分隔，如：gw:user:list,gw:user:create)")
    @NotBlank(message = "菜单授权码不能为空")
    private String perms;

    @ApiModelProperty(value = "菜单类型")
    @NotNull(message = "菜单类型不能为空")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private List<GwMenu> children=new ArrayList<>();

}
