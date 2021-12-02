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
@ApiModel(value="GwFilterResistor对象", description="")
public class GwFilterResistor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 滤波电阻器")
    private String modelName;

    @ApiModelProperty(value = "额定值")
    private Double rating;

    @ApiModelProperty(value = "谐振频率")
    private Double resonantFrequency;

    @ApiModelProperty(value = "谐振频率下的电感值")
    private Double inductanceAtResonantFrequency;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "暂态")
    private Double transientTrs;

    @ApiModelProperty(value = "冲击能量")
    private Double impactEnergy;

    @ApiModelProperty(value = "雷电波耐受水平")
    private Double lightningWaveWithstandLevel;

    @ApiModelProperty(value = "操作波耐受水平")
    private Double operatingWaveWithstandLevel;

    @ApiModelProperty(value = "爬距计算用电压")
    private Double voltageForCreepageCalculation;


}
