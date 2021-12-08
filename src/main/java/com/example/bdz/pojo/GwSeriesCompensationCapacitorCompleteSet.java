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
@ApiModel(value="GwSeriesCompensationCapacitorCompleteSet对象", description="")
public class GwSeriesCompensationCapacitorCompleteSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 串补电容器成套装置")
    private String modelName;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "额定容量")
    private Double ratedCapacity;

    @ApiModelProperty(value = "热稳定电流")
    private Double thermalStabilityCurrent;

    @ApiModelProperty(value = "动稳定电流")
    private Double dynamicStableCurrent;

    @ApiModelProperty(value = "补偿度")
    private Integer compensationDegree;

    @ApiModelProperty(value = "额定容抗")
    private Double ratedCapacitiveReactance;

    @ApiModelProperty(value = "过电压保护水平")
    private Double overvoltageProtectionLevel;

    @ApiModelProperty(value = "允许能耗水平")
    private Double allowableEnergyConsumptionLevel;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
