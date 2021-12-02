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
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwFilterCapacitor对象", description="")
public class GwFilterCapacitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 滤波电容器")
    private String modelName;

    @ApiModelProperty(value = "电容量")
    private Double capacitance;

    @ApiModelProperty(value = "额定容量")
    private Double ratedCapacity;

    @ApiModelProperty(value = "制造公差")
    private Double manufacturingTolerance;

    @ApiModelProperty(value = "环境温度从-25℃到40℃，电容参数变化范围")
    private Double variationRangeOfCapacitanceParameters;

    @ApiModelProperty(value = "最大持续运行电压")
    private Double maximumContinuousOperatingVoltage;

    @ApiModelProperty(value = "主要谐波")
    private Double mainHarmonic;

    @ApiModelProperty(value = "两端间爬距")
    private Double creepageDistanceBetweenTwoEnds;

    @ApiModelProperty(value = "高压端对地爬距")
    private Double creepageDistanceFromHighVoltageEndToGround;

    @ApiModelProperty(value = "低压端对地爬距")
    private Double creepageDistanceFromLowVoltageEndToGround;

    @ApiModelProperty(value = "噪声要求")
    private Double noiseRequirements;

    @ApiModelProperty(value = "噪声计算用谐波电流")
    private Double harmonicCurrentForNoiseCalculation;

    @ApiModelProperty(value = "最大噪声水平")
    private Double maximumNoiseLevel;

    @ApiModelProperty(value = "损耗角")
    private Double lossAngle;

    @ApiModelProperty(value = "高压端操作波耐受水平")
    private Double operatingWaveWithstandLevelAtHighVoltageEnd;

    @ApiModelProperty(value = "两端间操作波耐受水平")
    private Double operatingWaveWithstandLevelBetweenTwoEnds;

    @ApiModelProperty(value = "低压端操作波耐受水平")
    private Double operatingWaveWithstandLevelAtLowVoltageEnd;

    @ApiModelProperty(value = "高压端雷电波耐受水平")
    private Double lightningWaveWithstandLevelAtHighVoltageTerminal;

    @ApiModelProperty(value = "低压端雷电波耐受水平")
    private Double lightningWaveWithstandLevelAtLowVoltageTerminal;

    @ApiModelProperty(value = "正常无功功率")
    private Double normalReactivePower;

    @ApiModelProperty(value = "短路放电试验电压")
    private Double shortCircuitDischargeTestVoltage;

    @ApiModelProperty(value = "预期寿命")
    private Double lifeExpectancy;


}
