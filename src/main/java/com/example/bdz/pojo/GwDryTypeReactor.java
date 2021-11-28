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
@ApiModel(value="GwDryTypeReactor对象", description="")
public class GwDryTypeReactor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 干式电抗器")
    private String modelName;

    @ApiModelProperty(value = "设备型号")
    private String equipmentModel;

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

    @ApiModelProperty(value = "额定电感")
    private Double ratedInductance;

    @ApiModelProperty(value = "额定雷电冲击电压")
    private Double ratedLightningImpulseVoltage;

    @ApiModelProperty(value = "额定截波冲击电压")
    private Double ratedChoppedImpulseVoltage;

    @ApiModelProperty(value = "满载时噪声")
    private String noiseAtFullLoad;

    @ApiModelProperty(value = "端子允许受力（水平方向）")
    private Double horizontalDirection;

    @ApiModelProperty(value = "端子允许受力（垂直方向）")
    private Double verticalDirection;

    @ApiModelProperty(value = "端子允许受力（水平横向）")
    private Double horizontalTransverse;

    @ApiModelProperty(value = "电抗器外形尺寸")
    private Double overallDimensionOfReactor;

    @ApiModelProperty(value = "包装数")
    private Double numberOfPackages;

    @ApiModelProperty(value = "本体质量")
    private Double ontologyQuality;

    @ApiModelProperty(value = "附件质量")
    private Double accessoryQuality;

    @ApiModelProperty(value = "接线端子板材质")
    private String materialOfTerminalBlock;

    @ApiModelProperty(value = "额定电流，额定频率、75℃下的损耗比（即kW/kvar）")
    private String lossRatio;

    @ApiModelProperty(value = "电流不均匀度")
    private String currentNonuniformity;

    @ApiModelProperty(value = "温升限值（铁心、金属部分及与其相邻的材料）")
    private Double temperatureRiseLimit;

    @ApiModelProperty(value = "局放（1.05倍额定电压下）")
    private Double partialRelease;

    @ApiModelProperty(value = "直流电阻与出厂值相比及三相不均匀度")
    private Double nonuniformity;

    @ApiModelProperty(value = "感抗与额定值之差")
    private String differenceBetweenInductiveReactanceAndRatedValue;

    @ApiModelProperty(value = "三相感抗之互差")
    private String mutualDifferenceOfThreePhaseInductiveReactance;

    @ApiModelProperty(value = "1.2倍额定电压允许过负荷运行时间")
    private Double allowableOverloadOperationTime;

    @ApiModelProperty(value = "匝间耐压")
    private String turnToTurnWithstandVoltage;

    @ApiModelProperty(value = "在额定频率和95%额定电压下每相阻抗")
    private Double impedancePerPhase;

    @ApiModelProperty(value = "在额定频率和95%额定电压下电流")
    private Double electricCurrent;

    @ApiModelProperty(value = "在额定频率和95%额定电压下直流电阻")
    private Double dcResistance;

    @ApiModelProperty(value = "环境耐受性能")
    private String environmentalTolerance;

    @ApiModelProperty(value = "耐气候性能")
    private String weatherResistance;


}
