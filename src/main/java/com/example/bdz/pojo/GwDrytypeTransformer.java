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
 * @since 2021-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwDrytypeTransformer对象", description="")
public class GwDrytypeTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 干式变压器")
    private String modelName;

    @ApiModelProperty(value = "型式/单相、自耦、三绕组")
    private String type;

    @ApiModelProperty(value = "绝缘方式")
    private String insulationMode;

    @ApiModelProperty(value = "冷却方式")
    private String coolingMode;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "联结组标号")
    private String connectionSymbol;

    @ApiModelProperty(value = "额定频率")
    private Integer ratedFrequency;

    @ApiModelProperty(value = "高压侧容量")
    private Integer hvCapacity;

    @ApiModelProperty(value = "低压侧容量")
    private Integer lvCapacity;

    @ApiModelProperty(value = "高压侧电压")
    private Integer hvVoltage;

    @ApiModelProperty(value = "低压侧电压")
    private Integer lvVoltage;

    @ApiModelProperty(value = "调压方式")
    private String voltageRegulationMode;

    @ApiModelProperty(value = "调压位置")
    private String voltageRegulationPosition;

    @ApiModelProperty(value = "调压范围")
    private String voltageRegulationRange;

    @ApiModelProperty(value = "中性点接地方式")
    private String neutralGroundingMode;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "变压器运输时允许的最大倾斜度")
    private Double maximumAllowableInclinationDuringTransformerTransportat;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "短路阻抗（高压-低压）")
    private Double shortCircuitImpedanceHightolow;

    @ApiModelProperty(value = "高低阻抗允许偏差")
    private Double hlImpedanceDeviation;

    @ApiModelProperty(value = "雷电全波冲击电压（高压端子）")
    private Double lightningFullWaveImpulseVoltageHigh;

    @ApiModelProperty(value = "雷电截波冲击电压（高压端子）")
    private Double lightningChoppedImpulseVoltageHigh;

    @ApiModelProperty(value = "短时工频耐受电压（高压端子）")
    private Double shortTimePowerFrequencyWithstandVoltageHigh;

    @ApiModelProperty(value = "绕组温度限值")
    private Double windingTemperatureLimit;

    @ApiModelProperty(value = "绕组热点温度限值")
    private Double windingHotSpotTemperatureLimit;

    @ApiModelProperty(value = "空载损耗（额定频率额定电压）")
    private Double ratedVoltageNoloadloss;

    @ApiModelProperty(value = "空载电流（额定频率额定电压）")
    private Double ratedVoltageNoloadcurrent;

    @ApiModelProperty(value = "高中压负载损耗（主分接杂散损耗）")
    private Double highAndMediumVoltageLoadloss;

    @ApiModelProperty(value = "噪声水平（自然冷却）")
    private Double naturalCoolingNoiseLevel;

    @ApiModelProperty(value = "噪声水平（100%强迫冷风）")
    private Double forcedColdWindNoiseLevel;


}
