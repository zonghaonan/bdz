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
@ApiModel(value="GwPoleBusArresterInValveHall对象", description="")
public class GwPoleBusArresterInValveHall implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 阀厅内800kV极母线避雷器")
    private String modelName;

    @ApiModelProperty(value = "直流参考电压")
    private Double dcReferenceVoltage;

    @ApiModelProperty(value = "持续运行电压峰值")
    private Double continuousOperationVoltagePeak;

    @ApiModelProperty(value = "含换相过冲的最大持续运行电压峰值")
    private Double maxContinuousOperatingVoltagePeakWithCommutationOvershoot;

    @ApiModelProperty(value = "8/20μs雷电冲击电流下的最高残压(2kA)")
    private Double maximumResidualVoltageUnderLightningImpulseCurrent;

    @ApiModelProperty(value = "30/60μs操作冲击电流下的最高残压(200A)")
    private Double maximumResidualVoltageUnderOperatingImpulseCurrent;

    @ApiModelProperty(value = "4/10μs短时大电流耐受水平")
    private Double shortTimeHighCurrentWithstandLevel;

    @ApiModelProperty(value = "压力释放电流(大电流/小电流)")
    private Double pressureReliefCurrent;

    @ApiModelProperty(value = "雷电冲击耐受水平")
    private Double lightningImpulseWithstandLevel;

    @ApiModelProperty(value = "操作冲击耐受水平")
    private Double operatingImpulseWithstandLevel;

    @ApiModelProperty(value = "直流耐压")
    private Double dcWithstandVoltage;

    @ApiModelProperty(value = "确定避雷器最小爬电距离的电压")
    private Double voltageForDeterminingTheMinimumCreepageDistance;

    @ApiModelProperty(value = "10ms方波能量吸收能力")
    private Double squareWaveEnergyAbsorptionCapacity;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
