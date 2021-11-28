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
@ApiModel(value="GwCombinedElectricalApparatusHgis对象", description="")
public class GwCombinedElectricalApparatusHgis implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 组合电器HGIS")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "气体介质")
    private String gasMedium;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定电流（出线）")
    private Double 
ratedCurrentOut;

    @ApiModelProperty(value = "额定工频1min耐受电压（相对地）")
    private Double withstandVoltage;

    @ApiModelProperty(value = "额定操作冲击耐受电压峰值（250/2500s，相对地）")
    private Double operationImpulseWithstandVoltagePeak;

    @ApiModelProperty(value = "额定短路开断电流")
    private Double ratedShortcircuitBreakingCurrent;

    @ApiModelProperty(value = "额定短路关合电流")
    private Double ratedShortcircuitMakingCurrent;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间")
    private Double ratedShorttimeWithstandCurrentAndDuration;

    @ApiModelProperty(value = "额定峰值耐受电流")
    private Double ratedPeakWithstandCurrent;

    @ApiModelProperty(value = "辅助和控制回路短时工耐受电压")
    private Double shortTimeWithstandVoltageOfAuxiliaryAndControlCircui;

    @ApiModelProperty(value = "无线电干扰电压")
    private Double radioInterferenceVoltage;

    @ApiModelProperty(value = "噪声水平")
    private Double noiseLevel;

    @ApiModelProperty(value = "出线形式")
    private String outgoingLineForm;

    @ApiModelProperty(value = "断路器结构布置")
    private String circuitBreakerStructureLayout;

    @ApiModelProperty(value = "接线形式")
    private String wiringForm;

    @ApiModelProperty(value = "使用环境")
    private String usingEnvironment;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "每个隔室SF6气体漏气率")
    private Double eachGasLeakageRate;

    @ApiModelProperty(value = "有电弧分解物隔室SF6气体湿度（交接验收值）")
    private Double gasHumidityOfCompartmentWithArcDecomposition;

    @ApiModelProperty(value = "有电弧分解物隔室SF6气体湿度（长期运行允许值）")
    private Double gasHumidityOfCompartmentWithArcDecompositionLong;

    @ApiModelProperty(value = "无电弧分解物隔室SF6气体湿度（交接验收值）")
    private Double gasHumidityOfCompartmentWithoutArcDecomposition;

    @ApiModelProperty(value = "有电弧分解物隔室SF6气体湿度（长期运行允许值）")
    private Double gasHumidityOfCompartmentWithoutArcDecompositionLong;

    @ApiModelProperty(value = "局放（试验电压）")
    private Double partialReleaseOfTestVoltage;

    @ApiModelProperty(value = "局放（每个隔室）")
    private Double partialReleaseOfEachCompartment;

    @ApiModelProperty(value = "局放（每单个绝缘件）")
    private Double partialReleaseOfEachSingleInsulator;

    @ApiModelProperty(value = "局放（套管）")
    private Double partialReleaseOfBushing;

    @ApiModelProperty(value = "局放（电流互感器）")
    private Double partialReleaseOfCurrentTransformer;

    @ApiModelProperty(value = "控制回路供电电源")
    private String controlLoopPowerSupply;

    @ApiModelProperty(value = "辅助回路供电电源")
    private String auxiliaryCircuitPowerSupply;

    @ApiModelProperty(value = "使用寿命")
    private String serviceLife;

    @ApiModelProperty(value = "检修周期")
    private String maintenanceCycle;


}
