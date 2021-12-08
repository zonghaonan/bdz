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
@ApiModel(value="GwLightningArrester对象", description="")
public class GwLightningArrester implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 避雷器")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "系统标称电压")
    private Double systemNominalVoltage;

    @ApiModelProperty(value = "设备最高电压")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "额定频率")
    private Integer ratedFrequency;

    @ApiModelProperty(value = "电源的频率")
    private Double frequencyOfPowerSupply;

    @ApiModelProperty(value = "系统接地方式")
    private String systemGroundingMode;

    @ApiModelProperty(value = "安装点系统短路电流")
    private Double installationPointSystemShortCircuitCurrent;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "持续运行电压")
    private Double continuousOperatingVoltage;

    @ApiModelProperty(value = "标称放电电流")
    private Double nominalDischargeCurrent;

    @ApiModelProperty(value = "使用环境")
    private String useEnvironment;

    @ApiModelProperty(value = "外绝缘材质")
    private String externalInsulationMaterial;

    @ApiModelProperty(value = "直流1mA参考电压不小于")
    private Double referenceVoltage;

    @ApiModelProperty(value = "75%直流1mA参考电压漏电流")
    private String leakageCurrent;

    @ApiModelProperty(value = "操作冲击电流下的残压")
    private Double residualVoltageUnderOperatingImpulseCurrent;

    @ApiModelProperty(value = "雷电冲击电流下的最大残压")
    private Double maximumResidualVoltageUnderLightningImpulseCurrent;

    @ApiModelProperty(value = "陡波冲击电流下的最大残压")
    private Double maximumResidualVoltageUnderSteepWaveImpulseCurrent;

    @ApiModelProperty(value = "4/10μs大电流冲击耐受2次，电流及残压")
    private Double currentAndResidualVoltage;

    @ApiModelProperty(value = "线路放电等级")
    private Double lineDischargeLevel;

    @ApiModelProperty(value = "线路放电冲击电流峰值视在持续时间")
    private Double peakApparentDurationOfLineDischargeImpulseCurrent;

    @ApiModelProperty(value = "2ms方波冲击电流峰值")
    private Double peakValueOfSquareWaveImpulseCurrent;

    @ApiModelProperty(value = "额定短路电流")
    private Double ratedShortCircuitCurrent;

    @ApiModelProperty(value = "降低的短路电流±10%")
    private Double reducedShortCircuitCurrent;

    @ApiModelProperty(value = "小短路电流")
    private Double smallShortCircuitCurrent;

    @ApiModelProperty(value = "额定短时工频耐受电压")
    private Double withstandVoltage;

    @ApiModelProperty(value = "额定雷电冲击耐受电压峰值")
    private Double lightningImpulseWithstandVoltagePeak;

    @ApiModelProperty(value = "额定操作冲击耐受电压峰值")
    private Double operationImpulseWithstandVoltagePeak;

    @ApiModelProperty(value = "耐污能力（等值附盐密度）")
    private Double stainResistance;

    @ApiModelProperty(value = "局部放电量")
    private String localDischarge;

    @ApiModelProperty(value = "最大无线电干扰电压")
    private String maximumRadioInterferenceVoltage;

    @ApiModelProperty(value = "加速老化试验的荷电率")
    private String chargeRateOfAcceleratedAgingTest;

    @ApiModelProperty(value = "引线最大允许水平拉力")
    private Double maximumAllowableHorizontalTensionOfLead;

    @ApiModelProperty(value = "风速")
    private Double windSpeed;

    @ApiModelProperty(value = "能力水平加速度")
    private Double capabilityHorizontalAcceleration;

    @ApiModelProperty(value = "垂直加速度")
    private Double verticalAcceleration;

    @ApiModelProperty(value = "安全系数")
    private Double safetyFactor;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
