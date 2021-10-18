package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwPrefabs对象", description="")
public class GwPrefabs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "prefab_id", type = IdType.ASSIGN_ID)
    private Long prefabId;

    @ApiModelProperty(value = "物体名称")
    @NotBlank(message = "物体名称不能为空")
    private String prefabName;

    @ApiModelProperty(value = "物体类型")
    private String type;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户不能为空")
    private Long userId;

    @ApiModelProperty(value = "物体x坐标")
    @NotNull(message = "物体x坐标不能为空")
    private Float positionX;

    @ApiModelProperty(value = "物体y坐标")
    @NotNull(message = "物体y坐标不能为空")
    private Float positionY;

    @ApiModelProperty(value = "物体z坐标")
    @NotNull(message = "物体z坐标不能为空")
    private Float positionZ;

    @ApiModelProperty(value = "物体x朝向")
    private Float rotationX;

    @ApiModelProperty(value = "物体y朝向")
    private Float rotationY;

    @ApiModelProperty(value = "物体z朝向")
    private Float rotationZ;

    @ApiModelProperty(value = "物体x缩放")
    private Float scaleX;

    @ApiModelProperty(value = "物体y缩放")
    private Float scaleY;

    @ApiModelProperty(value = "物体z缩放")
    private Float scaleZ;

    @ApiModelProperty(value = "推流地址")
    private String url;

}
