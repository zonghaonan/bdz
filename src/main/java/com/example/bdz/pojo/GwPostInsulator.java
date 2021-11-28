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
@ApiModel(value="GwPostInsulator对象", description="")
public class GwPostInsulator implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 支柱绝缘子")
    private String modelName;

    @ApiModelProperty(value = "系统标称电压")
    private Double systemNominalVoltage;

    @ApiModelProperty(value = "设备最高电压")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "电源的频率")
    private Double frequencyOfPowerSupply;

    @ApiModelProperty(value = "系统接地方式")
    private String systemGroundingMode;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "材质")
    private String textureOfMaterial;

    @ApiModelProperty(value = "使用环境")
    private String useEnvironment;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "绝缘子高度")
    private Double insulatorHeight;

    @ApiModelProperty(value = "瓷件成型工艺")
    private String formingProcessOfPorcelainParts;

    @ApiModelProperty(value = "标准雷电冲击耐受电压（峰值）")
    private String standardLightningImpulseWithstandVoltage;

    @ApiModelProperty(value = "标准操作冲击湿耐受电压（峰值）")
    private String standardOperatingImpulseWetWithstandVoltage;

    @ApiModelProperty(value = "1min工频湿耐受电压（方均根值）")
    private Double powerFrequencyWetWithstandVoltage;

    @ApiModelProperty(value = "最小公称爬电距离")
    private String minNominalCreepageDistance;

    @ApiModelProperty(value = "绝缘件最大公称爬电距离")
    private Double maximumNominalCreepageDistanceOfInsulator;

    @ApiModelProperty(value = "额定弯曲破坏负荷")
    private String ratedBendingFailureLoad;

    @ApiModelProperty(value = "额定扭转破坏负荷")
    private String ratedTorsionalFailureLoad;

    @ApiModelProperty(value = "在1.1*Um√3kV无线电干扰电压")
    private String radioInterferenceVoltage;

    @ApiModelProperty(value = "期望寿命")
    private String lifeExpectancy;

    @ApiModelProperty(value = "干弧距离")
    private String dryArcDistance;

    @ApiModelProperty(value = "伞间距和伞伸出比值")
    private String umbrellaSpacingAndUmbrellaExtensionRatio;

    @ApiModelProperty(value = "上、下附件端面平行度最大偏差")
    private String maximumDeviationOfParallelism;

    @ApiModelProperty(value = "上、下附件安装孔中心圆轴线间最大偏差")
    private String maximumDeviationBetweenLines;

    @ApiModelProperty(value = "上、下附件安装孔角度偏移最大偏差（顺时针或逆时针方向）")
    private Double maximumDeviationOfAngleOffset;


}
