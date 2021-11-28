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
@ApiModel(value="GwEarthingSwitch对象", description="")
public class GwEarthingSwitch implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 接地开关")
    private String modelName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "隔离开关结构形式")
    private String structuralStyle;

    @ApiModelProperty(value = "操动机构型式或型号")
    private String structureAndType;

    @ApiModelProperty(value = "操作方式")
    private String operationModeOfDisconnector;

    @ApiModelProperty(value = "电动或手动")
    private String electricOrManual;

    @ApiModelProperty(value = "电动机电压")
    private String motorVoltage;

    @ApiModelProperty(value = "控制电压")
    private String controlVoltage;

    @ApiModelProperty(value = "备用辅助接点")
    private String standbyAuxiliaryContactOfGroundingSwitch;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "额定电流")
    private Double 
ratedCurrent;

    @ApiModelProperty(value = "端子静态负载（水平纵向）")
    private Double terminalStaticLoadHorizontalLongitudinal;

    @ApiModelProperty(value = "端子静态负载（水平横向）")
    private Double terminalStaticLoadHorizontalTransverse;

    @ApiModelProperty(value = "端子静态负载（垂直）")
    private Double terminalStaticVertical;

    @ApiModelProperty(value = "端子静态负载（静态安全系数）")
    private Double terminalStaticStaticSafetyFactor;

    @ApiModelProperty(value = "端子静态负载（动态安全系数）")
    private Double terminalStaticDynamicSafetyFactor;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "温升试验电流")
    private Double temperatureRiseTestCurrent;

    @ApiModelProperty(value = "额定工频1min耐受电压")
    private Double withstandVoltageFracture;

    @ApiModelProperty(value = "额定雷电冲击耐受电压峰值")
    private Double ratedLightningPointImpulseWithstandVoltage;

    @ApiModelProperty(value = "额定操作冲击耐受电压峰值")
    private Double operationImpulseWithstandVoltage;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间")
    private String ratedShorttimeWithstandCurrentAndDuration;

    @ApiModelProperty(value = "额定峰值耐受电流")
    private Double ratedPeakWithstandCurrent;

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


}
