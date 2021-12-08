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
@ApiModel(value="GwOutgoingCabinet对象", description="")
public class GwOutgoingCabinet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 35kV出线柜")
    private String modelName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "额定频率")
    private Double ratedFrequency;

    @ApiModelProperty(value = "温升电流")
    private String temperatureRiseCurrent;

    @ApiModelProperty(value = "额定工频耐受电压（断口）")
    private Double withstandVoltageFracture;

    @ApiModelProperty(value = "额定工频耐受电压（对地）")
    private Double withstandVoltageGround;

    @ApiModelProperty(value = "额定雷电冲击耐受电压（断口）")
    private Double ratedLightningPointImpulseWithstandVoltageFracture;

    @ApiModelProperty(value = "额定雷电冲击耐受电压（对地）")
    private Double ratedLightningPointImpulseWithstandVoltageGround;

    @ApiModelProperty(value = "额定短路开断电流")
    private Double ratedShortCircuitBreakingCurrent;

    @ApiModelProperty(value = "额定短路关合电流")
    private Double ratedShortCircuitMakingCurrent;

    @ApiModelProperty(value = "额定短时耐受电流及持续时间")
    private String ratedShortTimeWithstandCurrentAndDuration;

    @ApiModelProperty(value = "额定峰值耐受电流")
    private Double ratedPeakWithstandCurrent;

    @ApiModelProperty(value = "局放（试验电压）")
    private String partialReleaseTestVoltage;

    @ApiModelProperty(value = "局放（单个绝缘体）")
    private String partialReleaseSingleInsulator;

    @ApiModelProperty(value = "局放（电压互感器、电流互感器）")
    private String partialReleaseVoltageTransformer;

    @ApiModelProperty(value = "使用寿命")
    private String serviceLife;

    @ApiModelProperty(value = "柜深")
    private Double cabinetDepth;

    @ApiModelProperty(value = "柜宽")
    private Double cabinetWidth;

    @ApiModelProperty(value = "柜高")
    private Double cabinetHeight;

    @ApiModelProperty(value = "防护等级（柜体外壳）")
    private String degreeOfProtectionCabinetShell;

    @ApiModelProperty(value = "防护等级（隔离间）")
    private String degreeOfProtectionIsolationRoom;

    @ApiModelProperty(value = "爬电距离（有机材料（对地））")
    private Double creepageDistanceOrganic;

    @ApiModelProperty(value = "爬电距离（瓷质材料（对地））")
    private Double creepageDistancePorcelain;

    @ApiModelProperty(value = "空气净距（相间及相对地）")
    private String airClearance;

    @ApiModelProperty(value = "丧失运行连续性类别")
    private String lossOfOperationalContinuityCategory;

    @ApiModelProperty(value = "柜壁厚度")
    private String cabinetWallThickness;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
