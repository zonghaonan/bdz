package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2022-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwDistributionBox对象", description="")
public class GwDistributionBox implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 配电箱")
    private String modelName;

    @ApiModelProperty(value = "型号")
    private String type;

    @ApiModelProperty(value = "功能类型")
    private String functionType;

    @ApiModelProperty(value = "回路数")
    private Integer loopCount;

    @ApiModelProperty(value = "开关排数")
    private Integer switchRows;

    @ApiModelProperty(value = "电压")
    private Integer voltage;

    @ApiModelProperty(value = "电压单位")
    private String voltageUnit;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "壳体防护等级")
    private String shellProtectionLevel;

    @ApiModelProperty(value = "面料材质")
    private String material;

    @ApiModelProperty(value = "尺寸")
    private String size;

    @ApiModelProperty(value = "尺寸单位")
    private String sizeUnit;

    @ApiModelProperty(value = "板材厚度")
    private Double thick;

    @ApiModelProperty(value = "使用状况")
    private Integer status;


}
