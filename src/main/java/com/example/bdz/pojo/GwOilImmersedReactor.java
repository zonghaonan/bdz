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
@ApiModel(value="GwOilImmersedReactor对象", description="")
public class GwOilImmersedReactor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 油浸式电抗器")
    private String modelName;

    @ApiModelProperty(value = "设备型式")
    private String equipmentType;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "连续最高工作电压")
    private String continuousMaximumOperatingVoltage;

    @ApiModelProperty(value = "额定频率")
    private String ratedFrequency;

    @ApiModelProperty(value = "额定容量")
    private Double ratedCapacity;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "额定阻抗")
    private Double ratedImpedance;

    @ApiModelProperty(value = "额定电感")
    private Double ratedInductance;

    @ApiModelProperty(value = "额定雷电冲击电压")
    private Double ratedLightningImpulseVoltage;

    @ApiModelProperty(value = "额定截波冲击电压")
    private Double ratedChoppedImpulseVoltage;

    @ApiModelProperty(value = "损耗（额定电流，额定频率）")
    private String loss;

    @ApiModelProperty(value = "连接")
    private String connect;

    @ApiModelProperty(value = "水平纵向允许受力")
    private Double horizontalDirection;

    @ApiModelProperty(value = "垂直方向允许受力")
    private Double verticalDirection;

    @ApiModelProperty(value = "水平横向允许受力")
    private Double horizontalTransverse;

    @ApiModelProperty(value = "允许受力全系数")
    private String totalAllowableStressCoefficient;

    @ApiModelProperty(value = "直流电阻与出厂值相比及三相不均匀度")
    private Double nonuniformity;

    @ApiModelProperty(value = "绕组（平均值）温升极限")
    private String windingTemperatureRiseLimit;

    @ApiModelProperty(value = "绕组（热点）温升极限")
    private String windingHotSpotTemperatureRiseLimit;

    @ApiModelProperty(value = "油箱温升极限")
    private String temperatureRiseLimitOfOilTank;

    @ApiModelProperty(value = "铁心温升极限")
    private Double coreTemperatureRiseLimit;

    @ApiModelProperty(value = "125%额定电压下伏安特性曲线")
    private String voltAmpereCharacteristicCurve;

    @ApiModelProperty(value = "噪声")
    private Double noise;

    @ApiModelProperty(value = "额定雷电冲击耐电压（套管）")
    private Double lightningImpulseWithstandVoltage;

    @ApiModelProperty(value = "额定工频耐压（套管）")
    private Double ratedPowerFrequencyWithstandVoltage;

    @ApiModelProperty(value = "对地有效爬电距离")
    private String effectiveCreepageDistanceToGround;

    @ApiModelProperty(value = "弯曲耐受负荷")
    private String bendingWithstandLoad;

    @ApiModelProperty(value = "1.4倍额定电压下过励磁能力")
    private Double overExcitationCapacity14;

    @ApiModelProperty(value = "1.3倍额定电压下过励磁能力")
    private Double overExcitationCapacity13;

    @ApiModelProperty(value = "1..25倍额定电压下过励磁能力")
    private Double overExcitationCapacity125;

    @ApiModelProperty(value = "1.2倍额定电压下过励磁能力")
    private Double overExcitationCapacity12;

    @ApiModelProperty(value = "1.15倍额定电压下过励磁能力")
    private Double overExcitationCapacity115;

    @ApiModelProperty(value = "最高工作电压过励磁能力")
    private String maximumOperatingVoltageOverExcitationCapability;

    @ApiModelProperty(value = "与额定值误差（感抗误差）")
    private String deviationFromRatedValue;

    @ApiModelProperty(value = "与三相感抗之差（感抗误差）")
    private String differenceWithThreephaseInductiveReactance;

    @ApiModelProperty(value = "油箱侧面和底部的机械振动（平均值（峰对峰））")
    private String mechanicalVibrationAverage;

    @ApiModelProperty(value = "油箱侧面和底部的机械振动（最大值（峰对峰））")
    private String mechanicalVibrationMax;

    @ApiModelProperty(value = "油箱侧面和底部的机械振动（底部（峰对峰））")
    private String mechanicalVibrationBottom;

    @ApiModelProperty(value = "油箱真空度")
    private Double oilTankVacuum;

    @ApiModelProperty(value = "油箱和散热器压强")
    private Double tankAndRadiatorPressure;


}
