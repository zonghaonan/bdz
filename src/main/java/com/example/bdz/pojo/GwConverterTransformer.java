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
@ApiModel(value="GwConverterTransformer对象", description="")
public class GwConverterTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 换流变压器")
    private String modelName;

    @ApiModelProperty(value = "网侧绕组（送端）额定容量")
    private Double ratedCapacityOfGridSideWinding;

    @ApiModelProperty(value = "阀侧星形绕组（送端）额定容量")
    private Double ratedCapacityOfValveSideStarWinding;

    @ApiModelProperty(value = "网侧绕组（受端）额定容量")
    private Double ratedCapacityOfWindingAtReceivingEndNetworkSide;

    @ApiModelProperty(value = "阀侧星形绕组（送端）额定容量")
    private Double ratedCapacityOfStarWindingAtSendingEndValveSide;

    @ApiModelProperty(value = "顶部油温升")
    private Double topOilTemperatureRise;

    @ApiModelProperty(value = "网侧绕组平均温升")
    private Double averageTemperatureRiseOfGridSideWinding;

    @ApiModelProperty(value = "阀侧星形绕组平均温升")
    private Double averageTemperatureRiseOfValveSideStarWinding;

    @ApiModelProperty(value = "阀侧星形绕组热点温升")
    private Double hotSpotTemperatureRiseOfValveSideStarWinding;

    @ApiModelProperty(value = "额定频率")
    private Integer ratedFrequency;

    @ApiModelProperty(value = "网侧绕组额定电压")
    private Integer ratedVoltageOfGridSideWinding;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
