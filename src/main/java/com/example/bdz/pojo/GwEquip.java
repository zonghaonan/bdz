package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@ApiModel(value="GwEquip对象", description="")
public class GwEquip implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "资产名称")
    @NotBlank(message = "资产名称不能为空")
    private String equipName;

    @ApiModelProperty(value = "数量")
    @NotNull(message = "数量不能为空")
    private Integer count;

    @ApiModelProperty(value = "型号")
    private String type;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "使用状况(0:正常使用  1:故障)")
    @NotNull(message = "使用状况不能为空")
    private Integer status;

    @ApiModelProperty(value = "存放区域id")
    @NotNull(message = "存放区域不能为空")
    private Integer areaId;

    @ApiModelProperty(value = "存放区域名")
    @TableField(exist = false)
    private String areaName;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
