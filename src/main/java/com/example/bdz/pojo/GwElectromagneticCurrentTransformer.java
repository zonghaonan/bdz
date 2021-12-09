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
@ApiModel(value="GwElectromagneticCurrentTransformer对象", description="")
public class GwElectromagneticCurrentTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 电磁式电流互感器")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "绝缘介质")
    private String insulation;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "膨胀器型式")
    private String expanderType;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "设备最高电压Um")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "额定一次电流")
    private Double ratedPrimaryCurrent;

    @ApiModelProperty(value = "额定二次电流")
    private Double ratedSecondaryCurrent;

    @ApiModelProperty(value = "额定扩大一次电流值")
    private Double ratedExpandedPrimaryCurrent;

    @ApiModelProperty(value = "铁芯数")
    private String numberOfCores;

    @ApiModelProperty(value = "极性")
    private String polarity;

    @ApiModelProperty(value = "额定电流比（测量级）")
    private String ratedCurrentRatioMeasurementLevel;

    @ApiModelProperty(value = "额定电流比（测量级抽头）")
    private String ratedCurrentRatioMeasuringStageTap;

    @ApiModelProperty(value = "额定电流比（保护级）")
    private String ratedCurrentRatioProtectionLevel;

    @ApiModelProperty(value = "准确级组合（P级含准确限值系数ALF）")
    private String accuracyLevelCombination;

    @ApiModelProperty(value = "级次（额定输出）")
    private String ratedOutputLevel;

    @ApiModelProperty(value = "级次（功率因数cosφ）")
    private Double powerFactorLevel;

    @ApiModelProperty(value = "级次（测量级抽头额定输出）")
    private Double ratedOutputOfMeasuringStageTapLevel;

    @ApiModelProperty(value = "安装方式")
    private String installationMode;

    @ApiModelProperty(value = "通用设计编号")
    private String generalDesignNumber;

    @ApiModelProperty(value = "一次接线端子静态机械强度")
    private Double staticMechanicalStrengthOfPrimaryWiringTerminal;

    @ApiModelProperty(value = "端子机械强度（实际运行总载荷）")
    private Double mechanicalStrengthOfTerminalTotalLoad;

    @ApiModelProperty(value = "端子机械强度（极端动力荷载）")
    private Double mechanicalStrengthOfTerminalExtremeDynamicLoad;

    @ApiModelProperty(value = "套管材质")
    private String casingMaterial;

    @ApiModelProperty(value = "测量级仪表保安系数（FS）")
    private Double measurementLevelInstrumentSecurityFactor;

    @ApiModelProperty(value = "一次回路时间常数Tp")
    private String primaryLoopTimeConstant;

    @ApiModelProperty(value = "二次回路时间常数Ts")
    private String secondaryLoopTimeConstant;

    @ApiModelProperty(value = "对称短路电流倍数Kssc")
    private Double symmetricalShortCircuitCurrentMultiple;

    @ApiModelProperty(value = "TPX级或TPY级额定直流量偏移度")
    private Double ratedDirectFlowOffset;

    @ApiModelProperty(value = "TPX级或TPY级工作循环C-t' - 0")
    private String workingCycle;

    @ApiModelProperty(value = "TPX级或TPY级工作循环C-t' - 0-tfr-C-t''-0")
    private String workingCycleNext;

    @ApiModelProperty(value = "TPX级或TPY级保持准确限值时间t'al")
    private String maintainAccurateLimitTime;

    @ApiModelProperty(value = "TPX级或TPY级保持准确限值时间t''al")
    private String maintainAccurateLimitTimeNext;

    @ApiModelProperty(value = "额定二次负荷Rb")
    private String ratedSecondaryLoad;

    @ApiModelProperty(value = "TPS给定的面积增大系数K")
    private Double areaIncreasingCoefficient;

    @ApiModelProperty(value = "局放（Um电压下）")
    private Double partialReleaseOfUm;

    @ApiModelProperty(value = "局放（1.2Um/√3电压下）")
    private Double partialReleaseOfUm2;

    @ApiModelProperty(value = "雷电冲击耐受电压（峰值）")
    private Double lightningImpulseWithstandVoltage;

    @ApiModelProperty(value = "雷电冲击截波耐受电压（峰值）")
    private Double lightningImpulseCutoffWithstandVoltage;

    @ApiModelProperty(value = "操作冲击耐受电压（峰值、湿试）")
    private Double operatingImpulseWithstandVoltage;

    @ApiModelProperty(value = "一次绕组工频耐受电压（方均根值、干式）")
    private Double powerFrequencyWithstandVoltageOfPrimaryWinding;

    @ApiModelProperty(value = "一次绕组段间工频耐受电压（方均根值、干试）")
    private Double powerFrequencyWithstandVoltagePrimaryWindingSections;

    @ApiModelProperty(value = "二次绕组对地工频耐受电压（方均根值）")
    private Double powerFrequencyWithstandVoltageOfSecondaryWindingToGround;

    @ApiModelProperty(value = "二次绕组之间工频耐受电压（方均根值）")
    private Double powerFrequencyWithstandVoltageBetweenSecondaryWindings;

    @ApiModelProperty(value = "二次绕组匝间过电压（峰值）")
    private Double turnToTurnOvervoltageOfSecondaryWinding;

    @ApiModelProperty(value = "主绝缘介质损耗因数")
    private String dielectricLossFactorOfMainInsulation;

    @ApiModelProperty(value = "短时热稳定电流及持续时间（一次绕组并联时）")
    private Double shortTimeThermalStabilityCurrentAndDurationParallel;

    @ApiModelProperty(value = "短时热稳定电流及持续时间（一次绕组串联时）")
    private Double shortTimeThermalStabilityCurrentAndDurationSeries;

    @ApiModelProperty(value = "热稳定电流持续时间")
    private Double thermalStabilityCurrentDuration;

    @ApiModelProperty(value = "额定动稳定电流（一次绕组并联时）")
    private Double ratedDynamicStabilityCurrentParallel;

    @ApiModelProperty(value = "额定动稳定电流（一次绕组串联时）")
    private Double ratedDynamicStabilityCurrentSeries;

    @ApiModelProperty(value = "在1.1Um/√3压下无线电干扰电压")
    private String radioInterferenceVoltage;

    @ApiModelProperty(value = "在1.1Um/√3压下户外晴天夜晚无可见电晕")
    private String noVisibleCorona;

    @ApiModelProperty(value = "传递过电压限值（峰值）")
    private String transferOvervoltageLimit;

    @ApiModelProperty(value = "顶层油温限值")
    private Double topOilTemperatureLimit;

    @ApiModelProperty(value = "绕组温度限值")
    private Double windingTemperatureLimit;

    @ApiModelProperty(value = "一次绕组出头及连接处温度限值")
    private Double temperatureLimitOfPrimaryWindingOutletAndConnection;

    @ApiModelProperty(value = "伞裙结构")
    private String umbrellaSkirtStructure;

    @ApiModelProperty(value = "外绝缘最小爬电距离（乘以直径系数K）")
    private String minimumCreepageDistanceOfExternalInsulation;

    @ApiModelProperty(value = "套管干弧距离")
    private String casingDryArcDistance;

    @ApiModelProperty(value = "绝缘油击穿电压")
    private String breakdownVoltageOfInsulatingOil;

    @ApiModelProperty(value = "绝缘油tanδ（90℃）")
    private String insulatingOilTan;

    @ApiModelProperty(value = "绝缘油含水量")
    private String moistureContentOfInsulatingOil;

    @ApiModelProperty(value = "绝缘油总烃")
    private String totalHydrocarbonOfInsulatingOil;

    @ApiModelProperty(value = "绝缘油H2")
    private String insulatingOilH2;

    @ApiModelProperty(value = "预期寿命")
    private Double lifeExpectancy;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
