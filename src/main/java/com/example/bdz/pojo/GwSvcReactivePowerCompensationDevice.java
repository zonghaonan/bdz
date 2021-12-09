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
@ApiModel(value="GwSvcReactivePowerCompensationDevice对象", description="")
public class GwSvcReactivePowerCompensationDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 SVC无功补偿装置")
    private String modelName;

    @ApiModelProperty(value = "额定补偿电流")
    private String ratedCompensationCurrent;

    @ApiModelProperty(value = "型号")
    private String model;

    @ApiModelProperty(value = "补偿方式")
    private String compensationMode;

    @ApiModelProperty(value = "工作电压")
    private String workingVoltage;

    @ApiModelProperty(value = "工作频率")
    private String workingFrequency;

    @ApiModelProperty(value = "滤波能力")
    private String filteringAbility;

    @ApiModelProperty(value = "滤波范围")
    private String filteringRange;

    @ApiModelProperty(value = "单次谐波补偿调整率")
    private String singleHarmonicCompensationAdjustmentRate;

    @ApiModelProperty(value = "瞬时响应时间")
    private String instantaneousResponseIme;

    @ApiModelProperty(value = "全响应时间")
    private String fullResponseTime;

    @ApiModelProperty(value = "有功功率损耗")
    private String activePowerLoss;

    @ApiModelProperty(value = "校正三相不平衡")
    private String correctThreePhaseImbalance;

    @ApiModelProperty(value = "无补偿功能")
    private String noCompensationFunction;

    @ApiModelProperty(value = "开关频率")
    private String switchingFrequency;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
