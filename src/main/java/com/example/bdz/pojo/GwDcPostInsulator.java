package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwDcPostInsulator对象", description="")
public class GwDcPostInsulator implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 直流支柱绝缘子")
    private String modelName;

    @ApiModelProperty(value = "绝缘子类型")
    private Double insulatorType;

    @ApiModelProperty(value = "支柱绝缘子型号或代号")
    private Double modelOrCodeOfPostInsulator;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "最高运行电压")
    private Double maximumOperatingVoltage;

    @ApiModelProperty(value = "额定雷电冲击耐受电压(1.2/50μs,峰值)")
    private Double ratedLightningImpulseWithstandVoltage12;

    @ApiModelProperty(value = "额定雷电冲击耐受电压(250/2500μs,峰值)")
    private Double ratedLightningImpulseWithstandVoltage250;

    @ApiModelProperty(value = "端部抗弯破坏程度,支持式")
    private Double bendingFailureDegreeOfEnd;

    @ApiModelProperty(value = "抗扭破坏程度")
    private Double torsionalFailureDegree;

    @ApiModelProperty(value = "抗拉破坏程度")
    private Double tensileFailureDegree;

    @ApiModelProperty(value = "抗压破坏程度")
    private Double compressiveFailureDegree;

    @ApiModelProperty(value = "支柱绝缘子公称爬电距离")
    private Double nominalCreepageDistanceOfPostInsulator;

    @ApiModelProperty(value = "无线电干扰电压(RIV)")
    private Double riv;

    @ApiModelProperty(value = "结构高度")
    private Double structureHeight;

    @ApiModelProperty(value = "支柱绝缘子直径")
    private Double diameter;

    @ApiModelProperty(value = "支柱绝缘子重量")
    private Double weight;

    @ApiModelProperty(value = "支柱绝缘子外形尺寸")
    private Double overallDimension;


}
