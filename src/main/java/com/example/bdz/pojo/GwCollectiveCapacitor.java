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
@ApiModel(value="GwCollectiveCapacitor对象", description="")
public class GwCollectiveCapacitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 集合式电容器")
    private String modelName;

    @ApiModelProperty(value = "标称电压")
    private Double nominalVoltage;

    @ApiModelProperty(value = "最高运行电压")
    private Double maximumOperatingVoltage;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "中性点接地方式")
    private String neutralGroundingMode;

    @ApiModelProperty(value = "安装环境")
    private String installationEnvironment;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "标称容量")
    private Double nominalCapacity;

    @ApiModelProperty(value = "电抗率")
    private Double reactanceRate;

    @ApiModelProperty(value = "额定相电容")
    private Double ratedPhaseCapacitance;

    @ApiModelProperty(value = "额定雷点冲击耐压峰值")
    private Double ratedLightningPointImpulseWithstandVoltagePeak;

    @ApiModelProperty(value = "额定工频耐压")
    private Double ratedPowerFrequencyWithstandVoltage;

    @ApiModelProperty(value = "二次回路工频耐受电压")
    private Double powerFrequencyWithstandVoltageOfSecondaryCircuit;

    @ApiModelProperty(value = "电容器组电容与额定电容偏差")
    private Double deviationBetweenCapacitorBankCapacitanceRatedCapacitan;

    @ApiModelProperty(value = "三相电容器组的任何两线路端子之间，其电容的最大与最小电容之比")
    private String maxMinRatio;

    @ApiModelProperty(value = "电容器组各串联段的最大与最小电容之比")
    private String ratioCapacitanceOfEachSeriesSectionOfCapacitorBank;

    @ApiModelProperty(value = "臂间最大与最小电容之比")
    private String ratioOfMaximumToMinimumCapacitanceBetweenArms;

    @ApiModelProperty(value = "稳态过电流")
    private String steadyStateOvercurrent;

    @ApiModelProperty(value = "稳态过电压")
    private String steadyStateOvervoltage;

    @ApiModelProperty(value = "温升")
    private Double temperatureRise;

    @ApiModelProperty(value = "涌流限值")
    private String inrushCurrentLimit;

    @ApiModelProperty(value = "爆破能量")
    private String blastingEnergy;

    @ApiModelProperty(value = "接线形式")
    private String wiringForm;

    @ApiModelProperty(value = "每相电容器串联段数")
    private Double numberOfCapacitorSeriesSectionsPerPhase;

    @ApiModelProperty(value = "每相电容器并联台数")
    private Double numberOfParallelCapacitorsPerPhase;

    @ApiModelProperty(value = "保护方式")
    private String protectionMode;

    @ApiModelProperty(value = "单台电容器保护方式")
    private String singleCapacitorProtectionMode;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;


}
