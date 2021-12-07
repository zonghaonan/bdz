package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwOilfilledTransformer对象", description="")
public class GwOilfilledTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id,assign")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    @NotNull(message = "类别id不能为空")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称")
    private String modelName;

    @ApiModelProperty(value = "型式/单相、自耦、三绕组")
    private String type;

    @ApiModelProperty(value = "容量")
    private Double capacity;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "单位/示例：台")
    private String unit;

    @ApiModelProperty(value = "绝缘方式")
    private String insulation;

    @ApiModelProperty(value = "高压侧容量")
    private Double hvCapacity;

    @ApiModelProperty(value = "中压侧容量")
    private Double mvCapacity;

    @ApiModelProperty(value = "低压侧容量")
    private Double lvCapacity;

    @ApiModelProperty(value = "高压侧电压")
    private Double hvVoltage;

    @ApiModelProperty(value = "中压侧电压")
    private Double mvVoltage;

    @ApiModelProperty(value = "低压侧电压")
    private Double lvVoltage;

    @ApiModelProperty(value = "调压方式")
    private String voltageRegulationMode;

    @ApiModelProperty(value = "调压位置")
    private String voltageRegulationPosition;

    @ApiModelProperty(value = "调压范围")
    private String voltageRegulationRange;

    @ApiModelProperty(value = "中性点接地方式")
    private String neutralGroundingMode;

    @ApiModelProperty(value = "短路阻抗（高压-中压）")
    private Double shortCircuitImpedanceHightomid;

    @ApiModelProperty(value = "高中阻抗允许偏差")
    private Double hmImpedanceDeviation;

    @ApiModelProperty(value = "短路阻抗（高压-低压）")
    private Double shortCircuitImpedanceHightolow;

    @ApiModelProperty(value = "高低阻抗允许偏差")
    private Double hlImpedanceDeviation;

    @ApiModelProperty(value = "短路阻抗（中压-低压）")
    private Double shortCircuitImpedanceMidtolow;

    @ApiModelProperty(value = "中低阻抗允许偏差")
    private Double mlImpedanceDeviation;

    @ApiModelProperty(value = "冷却方式")
    private String coolingMode;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "联结组标号")
    private String connectionSymbol;

    @ApiModelProperty(value = "雷电全波冲击电压（高压端子）")
    private Double lightningFullWaveImpulseVoltageHigh;

    @ApiModelProperty(value = "雷电全波冲击电压（中压端子）")
    private Double lightningFullWaveImpulseVoltageMid;

    @ApiModelProperty(value = "雷电全波冲击电压（低压端子）")
    private Double lightningFullWaveImpulseVoltageLow;

    @ApiModelProperty(value = "雷电全波冲击电压（中性点端子）")
    private Double lightningFullWaveImpulseVoltageNeutral;

    @ApiModelProperty(value = "雷电截波冲击电压（高压端子）")
    private Double lightningChoppedImpulseVoltageHigh;

    @ApiModelProperty(value = "雷电截波冲击电压（中压端子）")
    private Double lightningChoppedImpulseVoltageMid;

    @ApiModelProperty(value = "雷电截波冲击电压（低压端子）")
    private Double lightningChoppedImpulseVoltageLow;

    @ApiModelProperty(value = "操作冲击电压（高压端子（对地））")
    private Double operatingImpulseVoltageHigh;

    @ApiModelProperty(value = "操作冲击电压（中压端子（对地））")
    private Double operatingImpulseVoltageMid;

    @ApiModelProperty(value = "短时工频耐受电压（高压端子）")
    private Double shortTimePowerFrequencyWithstandVoltageHigh;

    @ApiModelProperty(value = "短时工频耐受电压（中压端子）")
    private Double shortTimePowerFrequencyWithstandVoltageMid;

    @ApiModelProperty(value = "顶层油温限值")
    private Double topOilTemperatureLimit;

    @ApiModelProperty(value = "绕组温度限值")
    private Double windingTemperatureLimit;

    @ApiModelProperty(value = "油箱、铁心及金属温度限值")
    private Double tankCoreMetalTemperatureLimit;

    @ApiModelProperty(value = "绕组热点温度限值")
    private Double windingHotSpotTemperatureLimit;

    @ApiModelProperty(value = "高中压阻抗互差")
    private Double highAndMediumVoltageImpedanceDifference;

    @ApiModelProperty(value = "中低压阻抗互差")
    private Double mediumAndLowVoltageImpedanceDifference;

    @ApiModelProperty(value = "高低压阻抗互差")
    private Double highAndLowVoltageImpedanceDifference;

    @ApiModelProperty(value = "空载损耗（额定电压）")
    private Double ratedVoltageNoloadloss;

    @ApiModelProperty(value = "空载电流（额定电压）")
    private Double ratedVoltageNoloadcurrent;

    @ApiModelProperty(value = "高中压负载损耗（主分接）")
    private Double highAndMediumVoltageLoadloss;

    @ApiModelProperty(value = "噪声水平（风冷退出）")
    private Double airCoolingExitNoiseLevel;

    @ApiModelProperty(value = "噪声水平（风冷投入）")
    private Double airCoolingIuputNoiseLevel;

    @ApiModelProperty(value = "短路后绕组平均温度计算值")
    private Double averageWindingTemperatureAfterShortCircuit;

    @ApiModelProperty(value = "冷却装置停止运行后允许运行时间（强油循环）")
    private Double allowableRunningtimeAfterCoolingDeviceStopsRunning;

    @ApiModelProperty(value = "高压绕组局部水平")
    private Double localLevelOfHvWinding;

    @ApiModelProperty(value = "中压绕组局部水平")
    private Double localLevelOfMvWinding;

    @ApiModelProperty(value = "低压绕组局部水平")
    private Double localLevelOfLvWinding;

    @ApiModelProperty(value = "高压绕组连同套管的tanδ")
    private Double hvWindingWithBushingTandelta;

    @ApiModelProperty(value = "中压绕组连同套管的tanδ")
    private Double mvWindingWithBushingTandelta;

    @ApiModelProperty(value = "低压绕组连同套管的tanδ")
    private Double lvWindingWithBushingTandelta;

    @ApiModelProperty(value = "1.1Um/√3无线电干扰水平")
    private Double radioInterferenceLevel;

    @ApiModelProperty(value = "绕组中最高油流速度")
    private Double maxOilflowSpeedInWinding;

    @ApiModelProperty(value = "变压器运输时允许的最大倾斜度")
    private Double maximumAllowableInclinationDuringTransformerTransportation;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "高中压最大极限分接阻抗电压允许偏差")
    private Double allowableDeviationOfMaxLimitImpedanceVoltageOfHm;

    @ApiModelProperty(value = "中低压最大极限分接阻抗电压允许偏差")
    private Double allowableDeviationOfMaxLimitImpedanceVoltageOfMl;

    @ApiModelProperty(value = "高中压最小极限分接阻抗电压允许偏差")
    private Double allowableDeviationOfMinLimitImpedanceVoltageOfHm;

    @ApiModelProperty(value = "中低压最小极限分接阻抗电压允许偏差")
    private Double allowableDeviationOfMinLimitImpedanceVoltageOfMl;

    @ApiModelProperty(value = "效率")
    private Double efficiency;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
