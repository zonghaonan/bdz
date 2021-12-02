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
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwDcWallBushing对象", description="")
public class GwDcWallBushing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 直流穿墙套管")
    private String modelName;

    @ApiModelProperty(value = "长期直流电流")
    private Double longTermDcCurrent;

    @ApiModelProperty(value = "2h过负荷电流")
    private Double twohoursOverloadCurrent;

    @ApiModelProperty(value = "短时耐受电流")
    private Double shortTimeWithstandCurrent;

    @ApiModelProperty(value = "峰值耐受电流")
    private Double peakWithstandCurrent;

    @ApiModelProperty(value = "额定直流电压,对地UdN")
    private Double ratedDcVoltage;

    @ApiModelProperty(value = "最高连续直流电压,对地Udmax")
    private Double maximumContinuousDcVoltage;

    @ApiModelProperty(value = "设备最高电压Um相对地")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "第1级试验电压")
    private Double level1TestVoltage;

    @ApiModelProperty(value = "第2级试验电压")
    private Double level2TestVoltage;

    @ApiModelProperty(value = "第3级试验电压")
    private Double level3TestVoltage;

    @ApiModelProperty(value = "雷电冲击试验电压")
    private Double lightningImpulseTestVoltage;

    @ApiModelProperty(value = "操作冲击试验电压")
    private Double operatingImpulseTestVoltage;

    @ApiModelProperty(value = "工频1min试验电压")
    private Double powerFrequencyMin1TestVoltage;

    @ApiModelProperty(value = "工频1h试验电压+局放")
    private Double powerFrequencyH1TestVoltageAndPartialDischarge;

    @ApiModelProperty(value = "直流2h试验+局数")
    private Double dcH2TestAndNumberOfStations;

    @ApiModelProperty(value = "直流极性反转试验+局放")
    private Double dcPolarityReversalTestAndPartialDischarge;

    @ApiModelProperty(value = "直流湿态耐受电压")
    private Double dcWetWithstandVoltage;

    @ApiModelProperty(value = "用于无线电干扰测试的试验电压,端对地")
    private Double testVoltageForRadioInterferenceTest;

    @ApiModelProperty(value = "室外最小爬电比距")
    private Double outdoorMinimumCreepageDistance;

    @ApiModelProperty(value = "室内最小爬电比距")
    private Double indoorMinimumCreepageDistance;

    @ApiModelProperty(value = "水平纵向端子拉力")
    private Double horizontalLongitudinalTerminalTension;

    @ApiModelProperty(value = "水平横向端子拉力")
    private Double horizontalTransverseTerminalTension;

    @ApiModelProperty(value = "垂直方向端子拉力")
    private Double terminalTensionInVerticalDirection;


}
