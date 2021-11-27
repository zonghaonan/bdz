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
@ApiModel(value="GwHighVoltageShuntReactor对象", description="")
public class GwHighVoltageShuntReactor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 高压并联电抗器")
    private String modelName;

    @ApiModelProperty(value = "型式/单相、自耦、三绕组")
    private String type;

    @ApiModelProperty(value = "容量")
    private Double capacity;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "额定电压（高压）")
    private String ratedVoltageHigh;

    @ApiModelProperty(value = "额定电压（中压）")
    private Double ratedVoltageMid;

    @ApiModelProperty(value = "额定容量")
    private Double 
ratedCapacity;

    @ApiModelProperty(value = "额定电流")
    private Double 
ratedCurrent;

    @ApiModelProperty(value = "额定电抗")
    private Double 
ratedReactance;

    @ApiModelProperty(value = "额定电抗容许偏差")
    private String allowableDeviationOfRatedReactance;

    @ApiModelProperty(value = "三相间阻抗互差")
    private String impedanceDifferenceBetweenThreePhases;

    @ApiModelProperty(value = "中性点接地方式")
    private String neutralGroundingMode;

    @ApiModelProperty(value = "冷却方式")
    private String coolingMode;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "安装尺寸（长*宽*高）")
    private String mountingDimensions;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "器身质量")
    private Double bodyMass;

    @ApiModelProperty(value = "油质量")
    private Double oilQuality;

    @ApiModelProperty(value = "总质量")
    private Double totalQuality;

    @ApiModelProperty(value = "运输质量")
    private Double transportQuality;

    @ApiModelProperty(value = "雷电全波冲击电压（高压端子）")
    private Double lightningFullWaveImpulseVoltageHigh;

    @ApiModelProperty(value = "雷电全波冲击电压（中性点端子）")
    private Double lightningFullWaveImpulseVoltageNeutral;

    @ApiModelProperty(value = "雷电冲击截波电压（高压端子）")
    private Double lightningChoppedImpulseVoltageHigh;

    @ApiModelProperty(value = "操作冲击电压（高压端子）")
    private Double operatingImpulseVoltageHigh;

    @ApiModelProperty(value = "短时工频耐受电压（高压端子）")
    private Double shortTimePowerFrequencyWithstandVoltageHigh;

    @ApiModelProperty(value = "短时工频耐受电压（中性点端子）")
    private Double shortTimePowerFrequencyWithstandVoltageNeutral;

    @ApiModelProperty(value = "顶层油温限值")
    private Double topOilTemperatureLimit;

    @ApiModelProperty(value = "绕组温度限值")
    private Double windingTemperatureLimit;

    @ApiModelProperty(value = "油箱、铁心及金属温度限值")
    private Double tankCoreMetalTemperatureLimit;

    @ApiModelProperty(value = "绕组热点温度限值")
    private Double windingHotSpotTemperatureLimit;

    @ApiModelProperty(value = "1.5UN下的电流不大于1.5倍额定电流的百分数")
    private Double ratedCurrentConstraint;

    @ApiModelProperty(value = "1.4UN和1.7UN的连线平均斜率不小于初始斜率的百分数")
    private Double meanSlopeConstraint;

    @ApiModelProperty(value = "过励磁能力（1.50UN）")
    private Double overExcitationCapability150;

    @ApiModelProperty(value = "过励磁能力（1.40UN）")
    private Double overExcitationCapability140;

    @ApiModelProperty(value = "过励磁能力（1.30UN）")
    private Double overExcitationCapability130;

    @ApiModelProperty(value = "过励磁能力（1.25UN）")
    private Double overExcitationCapability125;

    @ApiModelProperty(value = "过励磁能力（1.20UN）")
    private Double overExcitationCapability120;

    @ApiModelProperty(value = "过励磁能力（1.15UN）")
    private Double overExcitationCapability115;

    @ApiModelProperty(value = "过励磁能力（1.10UN）")
    private Double overExcitationCapability110;

    @ApiModelProperty(value = "损耗")
    private Double loss;

    @ApiModelProperty(value = "噪声水平")
    private Double noiseLevel;

    @ApiModelProperty(value = "振动限值（平均值）")
    private Double averageVibrationLimit;

    @ApiModelProperty(value = "振动限值（最大值）")
    private Double maxVibrationLimit;

    @ApiModelProperty(value = "振动限值（油箱底部）")
    private Double buttonVibrationLimit;

    @ApiModelProperty(value = "局放")
    private Double partialRelease;

    @ApiModelProperty(value = "绕组连同套管的tanδ（20℃）")
    private Double windingWithBushingTandelta;

    @ApiModelProperty(value = "无线电干扰水平")
    private Double radioInterferenceLevel;


}
