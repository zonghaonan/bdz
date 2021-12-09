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
@ApiModel(value="GwConverterValve对象", description="")
public class GwConverterValve implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 换流阀")
    private String modelName;

    @ApiModelProperty(value = "标称直流电流IdN ")
    private Integer nominalDcCurrent;

    @ApiModelProperty(value = "标称直流电压，极对中性点UdRN")
    private Double poleToNeutral;

    @ApiModelProperty(value = "额定运行时最大持续直流电压")
    private Double maximumContinuousDcVoltage;

    @ApiModelProperty(value = "额定运行时最小持续直流电压")
    private Double minimumContinuousDcVoltage;

    @ApiModelProperty(value = "中性母线上最大持续直流电压")
    private Double maxOnNeutralBus;

    @ApiModelProperty(value = "整流运行时触发角")
    private Double triggerAngleDuringRectifierOperation;

    @ApiModelProperty(value = "标称值")
    private Double nominalValue;

    @ApiModelProperty(value = "额定功率时的最小值")
    private Double minimumAtRatedPower;

    @ApiModelProperty(value = "额定功率时的最大值")
    private Double maximumAtRatedPower;

    @ApiModelProperty(value = "最小值")
    private Double minimumValue;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
