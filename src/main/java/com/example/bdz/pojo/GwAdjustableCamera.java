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
@ApiModel(value="GwAdjustableCamera对象", description="")
public class GwAdjustableCamera implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 调相机")
    private String modelName;

    @ApiModelProperty(value = "额定容量")
    private Double ratedCapacity;

    @ApiModelProperty(value = "额定功率因数")
    private Double ratedPowerActor;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定电流")
    private Double ratedCurrent;

    @ApiModelProperty(value = "额定转速")
    private Double ratedSpeed;

    @ApiModelProperty(value = "绕组连接方式")
    private Double windingConnectionMode;

    @ApiModelProperty(value = "相数")
    private Double phaseNumber;

    @ApiModelProperty(value = "励磁方式")
    private Double excitationMode;

    @ApiModelProperty(value = "空载励磁方式(75℃)")
    private Double noloadExcitationMode;

    @ApiModelProperty(value = "空载励磁电流")
    private Double noloadExcitationCurrent;

    @ApiModelProperty(value = "额定励磁电压(130℃)")
    private Double ratedExcitationVoltage;

    @ApiModelProperty(value = "额定励磁电流")
    private Double ratedExcitationCurrent;

    @ApiModelProperty(value = "发电机不同工况下电负荷")
    private Double electricalLoadOfGeneratorUnderDifferentWorkingConditions;

    @ApiModelProperty(value = "空载工况")
    private Double noloadCondition;

    @ApiModelProperty(value = "额定工况")
    private Double ratedCondition;

    @ApiModelProperty(value = "进相150Mvar工况")
    private Double leadingPhaseMvar150WorkingCondition;

    @ApiModelProperty(value = "进相200Mvar工况")
    private Double leadingPhaseMvar200WorkingCondition;

    @ApiModelProperty(value = "强励")
    private Double forcedExcitation;

    @ApiModelProperty(value = "发电机转动惯量")
    private Double momentOfInertiaOfGenerator;


}
