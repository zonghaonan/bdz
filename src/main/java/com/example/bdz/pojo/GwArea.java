package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwCategory对象", description="")
public class GwArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "区域名称")
    @NotBlank(message = "区域名称不能为空")
    private String areaName;
    @ApiModelProperty(value = "区域资产个数")
    @TableField(exist = false)
    private Integer equipCount;

    public void setEquipCount(int area_id) {
    }
}
