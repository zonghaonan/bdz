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
@ApiModel(value="GwZeroFluxCurrentTransformer对象", description="")
public class GwZeroFluxCurrentTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 零磁通电流互感器")
    private String modelName;

    @ApiModelProperty(value = "型式")
    private String type;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定一次额定电流")
    private Double ratedPrimaryRatedCurrent;

    @ApiModelProperty(value = "额定短时热稳定电流")
    private Double ratedShorttimeThermalStabilityCurrent;

    @ApiModelProperty(value = "额定短时动稳定电流")
    private Double ratedShorttimeDynamicStabilityCurrent;

    @ApiModelProperty(value = "额定二次测量比率")
    private String ratedSecondaryMeasurementRatio;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
