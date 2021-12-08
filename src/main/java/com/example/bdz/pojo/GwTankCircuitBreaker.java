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
@ApiModel(value="GwTankCircuitBreaker对象", description="")
public class GwTankCircuitBreaker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 罐式断路器")
    private String modelName;

    @ApiModelProperty(value = "单位/示例：台")
    private String unit;

    @ApiModelProperty(value = "绝缘介质")
    private String insulatingMedium;

    @ApiModelProperty(value = "断路器型式或型号")
    private String type;

    @ApiModelProperty(value = "断口数")
    private Double fractureNumber;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "额定电流")
    private Double 
ratedCurrent;

    @ApiModelProperty(value = "温升试验电流")
    private Double temperatureRiseTestCurrent;

    @ApiModelProperty(value = "额定工频耐受电压（断口）")
    private Double withstandVoltageFracture;

    @ApiModelProperty(value = "额定工频耐受电压（对地）")
    private Double withstandVoltageGround;

    @ApiModelProperty(value = "额定雷电冲击耐受电压（断口）")
    private Double ratedLightningPointImpulseWithstandVoltageFracture;

    @ApiModelProperty(value = "额定雷电冲击耐受电压（对地）")
    private Double ratedLightningPointImpulseWithstandVoltageGround;

    @ApiModelProperty(value = "额定操作冲击耐受电压峰值（断口）")
    private Double operationImpulseWithstandVoltagePeakFracture;

    @ApiModelProperty(value = "额定操作冲击耐受电压峰值（对地）")
    private Double operationImpulseWithstandVoltagePeakGround;

    @ApiModelProperty(value = "额定短路开断电流（交流分量有效值）")
    private Double ratedShortcircuitBreakingCurrentEffective;

    @ApiModelProperty(value = "额定短路开断电流（时间常数）")
    private Double ratedShortcircuitBreakingCurrentTime;

    @ApiModelProperty(value = "额定短路开断电流（开断次数）")
    private String ratedShortcircuitBreakingCurrentCount;

    @ApiModelProperty(value = "额定短路开断电流（首相开断次数）")
    private Double ratedShortcircuitBreakingCurrentDisconnect;

    @ApiModelProperty(value = "额定短路关合电流")
    private Double ratedShortcircuitMakingCurrent;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间")
    private String ratedShorttimeWithstandCurrentAndDuration;

    @ApiModelProperty(value = "额定峰值耐受电流")
    private Double ratedPeakWithstandCurrent;

    @ApiModelProperty(value = "开断时间")
    private Double breakingTime;

    @ApiModelProperty(value = "分合时间")
    private Double openingAndClosingTime;

    @ApiModelProperty(value = "重合闸无电流间隙时间")
    private Double reclosingNoCurrentGapTime;

    @ApiModelProperty(value = "分闸不同期性（相间）")
    private Double openingAsynchronyAlternate;

    @ApiModelProperty(value = "分闸不同期性（同相断口间）")
    private Double openingAsynchronyInterphaseFracture;

    @ApiModelProperty(value = "相间合闸不同期性")
    private Double phaseToPhaseClosingAsynchrony;

    @ApiModelProperty(value = "同相断口间合闸不同期性")
    private Double asynchronousClosingBetweenInphaseFractures;

    @ApiModelProperty(value = "机械稳定性")
    private String mechanicalStability;

    @ApiModelProperty(value = "额定操作顺序")
    private String ratedOperatingSequence;

    @ApiModelProperty(value = "辅助和控制回路短时工耐受电压")
    private Double shortTimeWithstandVoltageOfAuxiliaryAndControlCircui;

    @ApiModelProperty(value = "无线电干扰电压")
    private Double radioInterferenceVoltage;

    @ApiModelProperty(value = "开合空载变压器容量")
    private String openingAndClosingNoloadTransformerCapacity;

    @ApiModelProperty(value = "开合空载变压器励磁电流")
    private String openingAndClosingExcitationCurrentOfNoloadTransformer;

    @ApiModelProperty(value = "开合空载变压器试验电压")
    private String openingAndClosingNoloadTransformerTestVoltage;

    @ApiModelProperty(value = "开合空载变压器操作顺序")
    private String operationSequenceOfOpeningAndClosingNoloadTransformer;

    @ApiModelProperty(value = "开合空载变压器操作次数")
    private String operationTimesOfOpeningAndClosingNoloadTransformer;

    @ApiModelProperty(value = "开合并联电抗器容量")
    private String switchingShuntReactorCapacity;

    @ApiModelProperty(value = "开合并联电抗器试验电压")
    private String testVoltageForOpeningAndClosingShuntReactor;

    @ApiModelProperty(value = "开合并联电抗器操作顺序")
    private String operationSequenceOfOpeningAndClosingShuntReactor;

    @ApiModelProperty(value = "开合并联电抗器操作次数")
    private String operationTimesOfOpeningAndClosingShuntReactor;

    @ApiModelProperty(value = "开合空载线路试验电流")
    private String openingAndClosingNoloadLineTestCurrent;

    @ApiModelProperty(value = "开合空载线路试验电压")
    private String openingAndClosingNoloadLineTestVoltage;

    @ApiModelProperty(value = "开合空载线路试验条件")
    private String testConditionsForOpeningAndClosingNoloadLine;

    @ApiModelProperty(value = "开合空载线路操作顺序")
    private String operationSequenceOfOpeningAndClosingNoloadLine;

    @ApiModelProperty(value = "开合空载线路操作次数")
    private String operationTimesOfOpeningAndClosingNoloadLine;

    @ApiModelProperty(value = "容性电流开合试验电流")
    private String capacitiveCurrentSwitchingTestCurrent;

    @ApiModelProperty(value = "容性电流开合试验电压")
    private String capacitiveCurrentSwitchingTestVoltage;

    @ApiModelProperty(value = "容性电流开合试验操作顺序")
    private String operationSequenceOfCapacitiveCurrentSwitchingTest;

    @ApiModelProperty(value = "近区故障试验（L90）")
    private String nearFieldFaultTest;

    @ApiModelProperty(value = "故障试验（L75）")
    private String faultTestL75;

    @ApiModelProperty(value = "故障试验（L60）")
    private String faultTestL60;

    @ApiModelProperty(value = "故障试验（操作顺序）")
    private String operationSequenceFaultTest;

    @ApiModelProperty(value = "开断电流（失步关合和开断试验）")
    private String 
breakingCurrent;

    @ApiModelProperty(value = "工频恢复电压（失步关合和开断试验）")
    private String powerFrequencyRecoveryVoltage;

    @ApiModelProperty(value = "恢复电压上升率（失步关合和开断试验）")
    private Double recoveryVoltageRiseRate;

    @ApiModelProperty(value = "操作顺序（失步关合和开断试验）")
    private String operationSequence;

    @ApiModelProperty(value = "合闸电阻值")
    private Double closingResistanceValue;

    @ApiModelProperty(value = "合闸电阻值允许偏差")
    private String allowableDeviationOfClosingResistanceValue;

    @ApiModelProperty(value = "合闸电阻预投入时间")
    private String preInputTimeOfClosingResistance;

    @ApiModelProperty(value = "合闸电阻热容量")
    private String thermalCapacityOfClosingResistance;

    @ApiModelProperty(value = "断口均压电容器额定电压")
    private String ratedVoltageOfBreakVoltageEqualizingCapacitor;

    @ApiModelProperty(value = "断口均压电容器电容量允许偏差")
    private String allowableBreakVoltageEqualizingCapacitor;

    @ApiModelProperty(value = "断口均压电容器耐受电压")
    private String withstandVoltageOfBreakVoltageEqualizingCapacitor;

    @ApiModelProperty(value = "断口均压电容器局部放电量")
    private String partialDischargeOfBreakVoltageEqualizingCapacitor;

    @ApiModelProperty(value = "断口均压电容器介损值")
    private String dielectricLossValueOfBreakVoltageEqualizingCapacitor;

    @ApiModelProperty(value = "S气体湿度（交接验收值）")
    private String gasHumidityHandoverAcceptanceValue;

    @ApiModelProperty(value = "S气体湿度（长期运行允许值）")
    private String gasHumidityAllowableValueForLongtermOperation;

    @ApiModelProperty(value = "S气体漏气率")
    private String gasLeakageRate;

    @ApiModelProperty(value = "S气体纯度")
    private Double gasPurity;

    @ApiModelProperty(value = "断路器相间距离")
    private Double phaseToPhaseDistanceOfCircuitBreaker;

    @ApiModelProperty(value = "套管爬电距离（对地/断口）")
    private String creepageDistanceOfCasing;

    @ApiModelProperty(value = "套管干弧距离")
    private String casingDryArcDistance;

    @ApiModelProperty(value = "套管S/P")
    private String bushingSp;

    @ApiModelProperty(value = "端子静负载（水平纵向）")
    private Double terminalStaticLoadHorizontalLongitudinal;

    @ApiModelProperty(value = "端子静负载（水平横向）")
    private Double terminalStaticLoadHorizontalTransverse;

    @ApiModelProperty(value = "端子静负载（垂直）")
    private Double terminalStaticVertical;

    @ApiModelProperty(value = "端子静负载（安全系）")
    private Double terminalStaticSecuritySystem;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
