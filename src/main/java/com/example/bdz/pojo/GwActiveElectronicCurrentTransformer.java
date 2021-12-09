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
@ApiModel(value="GwActiveElectronicCurrentTransformer对象", description="")
public class GwActiveElectronicCurrentTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 有源电子式电流互感器")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "合并单元输出")
    private String mergeUnitOutput;

    @ApiModelProperty(value = "一次传感器数量")
    private Integer numberOfPrimarySensors;

    @ApiModelProperty(value = "采样频率")
    private Double samplingFrequency;

    @ApiModelProperty(value = "额定一次电流")
    private Double ratedPrimaryCurrent;

    @ApiModelProperty(value = "额定扩大一次电流值 ")
    private Double ratedExpandedPrimaryCurrent;

    @ApiModelProperty(value = "低压元器件工频耐压")
    private Double powerFrequencyWithstandVoltageOfLowVoltageComponents;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
