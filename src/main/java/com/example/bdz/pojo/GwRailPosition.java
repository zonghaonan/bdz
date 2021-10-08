package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwRailPosition对象", description="")
public class GwRailPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "点的x坐标")
    @NotNull(message = "点的x坐标不能为空")
    private Float positionX;

    @ApiModelProperty(value = "点的y坐标")
    @NotNull(message = "点的y坐标不能为空")
    private Float positionY;

    @ApiModelProperty(value = "点的z坐标")
    @NotNull(message = "点的z坐标不能为空")
    private Float positionZ;

    @ApiModelProperty(value = "编号")
    private Long railId;


}
