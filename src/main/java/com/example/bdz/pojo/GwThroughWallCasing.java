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
 * @since 2021-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwThroughWallCasing对象", description="")
public class GwThroughWallCasing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 穿墙套管")
    private String modelName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "材质")
    private String textureOfMaterial;

    @ApiModelProperty(value = "接线端子板材料")
    private String terminalBlockMaterial;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "设备最高电压Um")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "热稳定电流（有效值）/持续时间")
    private Double thermalStabilityCurrent;

    @ApiModelProperty(value = "全波冲击电压（峰值）")
    private Double fullWaveImpulseVoltage;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "端子机械强度（静态）")
    private String mechanicalStrengthOfTerminalStaticState;

    @ApiModelProperty(value = "端子机械强度（实际运行总荷载）")
    private String mechanicalStrengthOfTerminalActualOperation;

    @ApiModelProperty(value = "端子机械强度（极端动力荷载）")
    private String mechanicalStrengthOfTerminalExtremePower;

    @ApiModelProperty(value = "弯曲耐受负荷")
    private Double bendingWithstandLoad;

    @ApiModelProperty(value = "1min工频湿耐压")
    private Double powerFrequencyWetWithstandVoltage;

    @ApiModelProperty(value = "1min工频干耐压")
    private Double powerFrequencyDryWithstandVoltage;

    @ApiModelProperty(value = "使用寿命")
    private Integer serviceLife;

    @ApiModelProperty(value = "爬电距离（户外）")
    private Double creepageDistanceOutdoors;

    @ApiModelProperty(value = "爬电距离（户内）")
    private Double creepageDistanceIndoor;

    @ApiModelProperty(value = "介质损耗因数tanδ（1.05Ur/√3下）")
    private Double dielectricLossFactor;

    @ApiModelProperty(value = "tanδ增量（电压从1.05Ur/√3升到Ur时）")
    private Double increment;

    @ApiModelProperty(value = "电容增量（在1.05Ur/√3下）")
    private String capacitanceIncrement;

    @ApiModelProperty(value = "测量端子的介质损耗因数tanδ")
    private Double measureTheDielectricLossFactorOfTheTerminal;

    @ApiModelProperty(value = "温升（导线）")
    private Double 
temperatureRiseWireway;

    @ApiModelProperty(value = "温升（设备线夹）")
    private Double 
temperatureRiseEquipmentClamp;

    @ApiModelProperty(value = "最高允许温升（短时热电流耐受及持续时间）")
    private Double maximumAllowableTemperatureRise;

    @ApiModelProperty(value = "持续时间（短时热电流耐受及持续时间）")
    private Double duration;


}
