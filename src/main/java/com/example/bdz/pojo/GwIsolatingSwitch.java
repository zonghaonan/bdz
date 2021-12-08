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
 * @since 2021-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwIsolatingSwitch对象", description="")
public class GwIsolatingSwitch implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 隔离开关")
    private String modelName;

    @ApiModelProperty(value = "隔离开关结构形式")
    private String structuralStyle;

    @ApiModelProperty(value = "隔离开关类型")
    private String type;

    @ApiModelProperty(value = "操动机构型式或型号")
    private String structureAndTypeOfGroundingSwitch;

    @ApiModelProperty(value = "隔离开关操作方式")
    private String operationModeOfDisconnector;

    @ApiModelProperty(value = "隔离开关电动或手动")
    private String electricOrManual;

    @ApiModelProperty(value = "隔离开关电动机电压")
    private String motorVoltage;

    @ApiModelProperty(value = "隔离开关控制电压")
    private String controlVoltage;

    @ApiModelProperty(value = "接地开关操动机构型式或型号")
    private String operatingModeOfOperatingMechanism;

    @ApiModelProperty(value = "接地开关操动机构操作方式")
    private String operationModeOfGroundingSwitchOperatingMechanism;

    @ApiModelProperty(value = "接地开关电动或手动")
    private String earthingSwitchElectricOrManual;

    @ApiModelProperty(value = "接地开关电动机电压")
    private String earthingSwitchMotorVoltage;

    @ApiModelProperty(value = "接地开关控制电压")
    private String earthingSwitchControlVoltage;

    @ApiModelProperty(value = "隔离开关备用辅助接点")
    private String standbyAuxiliaryContactOfDisconnector;

    @ApiModelProperty(value = "接地开关备用辅助接点")
    private String standbyAuxiliaryContactOfGroundingSwitch;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "额定电流")
    private Double 
ratedCurrent;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "双接地")
    private String groundingMode;

    @ApiModelProperty(value = "隔离开关开合状态")
    private String openingAndClosingStateOfDisconnector;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间（隔离开关）")
    private String ratedShorttimeWithstandCurrentAndDuration;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间（接地开关）")
    private String ratedShorttimeWithstandCurrentAndDurationGround;

    @ApiModelProperty(value = "额定峰值耐受电流")
    private Double ratedPeakWithstandCurrent;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "端子静态负载（水平纵向）")
    private Double terminalStaticLoadHorizontalLongitudinal;

    @ApiModelProperty(value = "端子静态负载（水平横向）")
    private Double terminalStaticLoadHorizontalTransverse;

    @ApiModelProperty(value = "端子静态负载（垂直）")
    private Double terminalStaticVertical;

    @ApiModelProperty(value = "端子静态负载（安全系数）")
    private Double terminalStaticSecuritySystem;

    @ApiModelProperty(value = "支撑导线纵向位移（硬母线）")
    private Double longitudinalDisplacementOfSupportingConductor;

    @ApiModelProperty(value = "水平总偏移（硬母线）")
    private Double totalHorizontalOffset;

    @ApiModelProperty(value = "垂直偏移（硬母线）")
    private Double verticalOffset;

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

    @ApiModelProperty(value = "转换电流")
    private Double conversionCurrent;

    @ApiModelProperty(value = "恢复电压")
    private Double recoveryVoltage;

    @ApiModelProperty(value = "开断次数")
    private Double breakingTimes;

    @ApiModelProperty(value = "开合小电容电流")
    private Double openingAndClosingSmallCapacitanceCurrent;

    @ApiModelProperty(value = "电磁感应（感性电流）")
    private String electromagneticInductionInductiveCurrent;

    @ApiModelProperty(value = "电磁感应（感性电压）")
    private String electromagneticInductionInductiveVoltage;

    @ApiModelProperty(value = "电磁感应（开断次数）")
    private Double electromagneticInductionBreakingTimes;

    @ApiModelProperty(value = "静电感应（容性电流）")
    private String electrostaticInductionCapacitiveCurrent;

    @ApiModelProperty(value = "静电感应（感应电压）")
    private String electrostaticInductionInducedVoltage;

    @ApiModelProperty(value = "静电感应（开断次数）")
    private Double electrostaticInductionBreakingTimes;

    @ApiModelProperty(value = "机械稳定性")
    private String mechanicalStability;

    @ApiModelProperty(value = "辅助和控制回路短时工耐受电压")
    private Double shortTimeWithstandVoltageOfAuxiliaryAndControlCircui;

    @ApiModelProperty(value = "无线电干扰电压")
    private String radioInterferenceVoltage;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
