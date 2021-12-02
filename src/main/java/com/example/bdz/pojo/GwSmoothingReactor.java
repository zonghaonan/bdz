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
@ApiModel(value="GwSmoothingReactor对象", description="")
public class GwSmoothingReactor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 平波电抗器")
    private String modelName;

    @ApiModelProperty(value = "额定谐振频率")
    private Double ratedResonantFrequency;

    @ApiModelProperty(value = "谐振频率下的额定电感")
    private Double ratedInductance;

    @ApiModelProperty(value = "参数偏差")
    private Double parameterDeviation;

    @ApiModelProperty(value = "调节范围")
    private Double adjustmentRange;

    @ApiModelProperty(value = "调节极差")
    private Double adjustmentMaxMin;

    @ApiModelProperty(value = "额定谐振频率时的Q-值")
    private Double ratedResonantFrequencyQvalue;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "额定持续运行电流")
    private Double ratedContinuousOperatingCurrent;

    @ApiModelProperty(value = "额定持续运行电流主要谐波")
    private Double mainHarmonic;

    @ApiModelProperty(value = "最大暂时电流，在10分钟")
    private Double maximumTemporaryCurrentTenmin;

    @ApiModelProperty(value = "最大暂时电流，在30秒")
    private Double maximumTemporaryCurrentThirtysex;

    @ApiModelProperty(value = "噪声计算用电流")
    private Double currentForNoiseCalculation;

    @ApiModelProperty(value = "额定冲击电流")
    private Double ratedImpulseCurrent;

    @ApiModelProperty(value = "第1峰值")
    private Double firstPeak;

    @ApiModelProperty(value = "谐振频率")
    private Double resonantFrequency;

    @ApiModelProperty(value = "时间常数")
    private Double timeConstant;

    @ApiModelProperty(value = "爬距计算电压")
    private Double creepageCalculationVoltage;

    @ApiModelProperty(value = "两端间")
    private Double betweenTwoEnds;

    @ApiModelProperty(value = "低压端对地")
    private Double lowVoltageTerminalToGround;

    @ApiModelProperty(value = "雷电波耐受水平")
    private Double lightningWaveWithstandLevel;

    @ApiModelProperty(value = "高压端对地")
    private Double highVoltageTerminalToGround;


}
