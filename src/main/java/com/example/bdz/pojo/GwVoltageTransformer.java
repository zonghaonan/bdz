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
 * @since 2021-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwVoltageTransformer对象", description="")
public class GwVoltageTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 零磁通电流互感器")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "绝缘介质")
    private String insulation;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "设备最高电压Um")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "额定一次电压U1N")
    private String ratedPrimaryVoltage;

    @ApiModelProperty(value = "额定二次电压（主二次绕组）")
    private String ratedSecondaryVoltageMain;

    @ApiModelProperty(value = "额定二次电压（剩余绕组）")
    private String ratedSecondaryVoltageSurplus;

    @ApiModelProperty(value = "额定电压比")
    private String ratedVoltageRatio;

    @ApiModelProperty(value = "额定标准级组合")
    private String ratedStandardClassCombination;

    @ApiModelProperty(value = "额定输出组合")
    private String ratedOutputCombination;

    @ApiModelProperty(value = "额定输出功率因数cos")
    private Double ratedOutputPowerFactor;

    @ApiModelProperty(value = "极性")
    private String polarity;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "端子机械强度（静态）")
    private Double mechanicalStrengthOfTerminalStaticState;

    @ApiModelProperty(value = "端子机械强度（实际运行总载荷）")
    private String mechanicalStrengthOfTerminalTotalLoad;

    @ApiModelProperty(value = "额定电压因数及持续时间")
    private String ratedVoltageFactorAndDuration;

    @ApiModelProperty(value = "额定电容Cn")
    private Double ratedCapacitance;

    @ApiModelProperty(value = "实测电容对额定电容相对偏差不大于")
    private String relativeDeviation;

    @ApiModelProperty(value = "组成电容器叠柱的任何两个单元的电容之比值偏差，应不超过其单元额定电压之比的倒数的百分数")
    private String ratioDeviation;

    @ApiModelProperty(value = "电容分压器温度系数")
    private String temperatureCoefficientOfCapacitiveVoltageDivider;

    @ApiModelProperty(value = "分压器绝缘水平（高压端雷电冲击耐受电压）")
    private Double insulationLevelOfVoltageDividerLighting;

    @ApiModelProperty(value = "分压器绝缘水平（高压端截波冲击耐受电压）")
    private Double insulationLevelOfVoltageDividerTruncatedWave;

    @ApiModelProperty(value = "分压器绝缘水平（高压端操作冲击耐受电压）")
    private Double insulationLevelOfVoltageDividerOperation;

    @ApiModelProperty(value = "分压器绝缘水平（高压端工频耐受电压）")
    private Double insulationLevelOfVoltageDividerPowerFrequency;

    @ApiModelProperty(value = "电磁单元绝缘水平（中压回路接地端工频耐受电压）")
    private Double insulationLevelOfElectromagneticUnitMediumVoltage;

    @ApiModelProperty(value = "电磁单元绝缘水平（δ端子工频耐受电压）")
    private Double insulationLevelOfElectromagneticUnitTerminal;

    @ApiModelProperty(value = "电磁单元绝缘水平（二次绕组之间及对地工频耐受电压）")
    private Double insulationLevelOfElectromagneticUnitSecondaryWinding;

    @ApiModelProperty(value = "在10kV电压下电容分压器介质损耗因数tanδ")
    private String dielectricLossFactor;

    @ApiModelProperty(value = "局放（Um电压下）")
    private Double partialReleaseOfUm;

    @ApiModelProperty(value = "局放（1.2Um/√3电压下）")
    private Double partialReleaseOfVolt;

    @ApiModelProperty(value = "传递过电压峰值限值")
    private String transferOvervoltagePeakLimit;

    @ApiModelProperty(value = "顶层油温限值")
    private String topOilTemperatureLimit;

    @ApiModelProperty(value = "绕组温升限值")
    private String windingTemperatureRiseLimit;

    @ApiModelProperty(value = "油箱、铁心及金属温度限值")
    private Double tankCoreMetalTemperatureLimit;

    @ApiModelProperty(value = "绝缘油击穿电压不小于")
    private String breakdownVoltageOfInsulatingOil;

    @ApiModelProperty(value = "绝缘油tanδ（90℃）不大于")
    private String insulatingOilTan;

    @ApiModelProperty(value = "瞬变响应")
    private String transientResponse;

    @ApiModelProperty(value = "铁磁谐振特性（0.8U1N）")
    private String ferromagneticResonanceCharacteristics;

    @ApiModelProperty(value = "铁磁谐振特性（1.0U1N）")
    private String ferromagneticResonanceCharacteristicsSec;

    @ApiModelProperty(value = "铁磁谐振特性（1.2U1N）")
    private String ferromagneticResonanceCharacteristicsThird;

    @ApiModelProperty(value = "铁磁谐振特性（1.5U1N）")
    private String ferromagneticResonanceCharacteristicsFourth;

    @ApiModelProperty(value = "截波工作频率范围")
    private String choppingFrequency;

    @ApiModelProperty(value = "高频电容实测值对额定电容的相对偏差不大于")
    private String measuredValueOfHighFrequencyCapacitance;

    @ApiModelProperty(value = "等值串联电阻")
    private String equivalentSeriesResistance;

    @ApiModelProperty(value = "低压端对地的杂散电容")
    private String strayCapacitanceOfLowVoltageTerminalToGround;

    @ApiModelProperty(value = "低压端对地的杂散电导")
    private String strayConductanceOfLowVoltageTerminalToGround;

    @ApiModelProperty(value = "发生损坏或性能变化时通过的稳态高频电流")
    private Double steadyStateHighFrequencyCurrent;

    @ApiModelProperty(value = "当一次绕组施加三相平衡电压时，三相互感器组剩余电压绕组接成开口三角后剩余电压不大于")
    private Double residualVoltage;

    @ApiModelProperty(value = "阻尼方式")
    private String dampingMode;

    @ApiModelProperty(value = "结构要求")
    private String structuralRequirements;

    @ApiModelProperty(value = "套管材质")
    private String casingMaterial;

    @ApiModelProperty(value = "伞裙结构")
    private String umbrellaSkirtStructure;

    @ApiModelProperty(value = "外绝缘爬电距离（乘以Kd）")
    private String creepageDistanceOfExternalInsulation;

    @ApiModelProperty(value = "套管干弧距离")
    private String casingDryArcDistance;

    @ApiModelProperty(value = "爬电距离")
    private String creepageDistance;

    @ApiModelProperty(value = "期望寿命")
    private Double lifeExpectancy;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
