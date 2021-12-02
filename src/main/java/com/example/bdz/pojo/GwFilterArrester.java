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
@ApiModel(value="GwFilterArrester对象", description="")
public class GwFilterArrester implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 滤波避雷器")
    private String modelName;

    @ApiModelProperty(value = "最大持续运行电压(CCOV)")
    private Double ccov;

    @ApiModelProperty(value = "主要谐波")
    private Double mainHarmonic;

    @ApiModelProperty(value = "参考电压")
    private Double referenceVoltage;

    @ApiModelProperty(value = "雷电波,8/20μs")
    private Double lightningWave;

    @ApiModelProperty(value = "操作波,30/60μs")
    private Double operatingWave;

    @ApiModelProperty(value = "最大能量")
    private Double maximumEnergy;

    @ApiModelProperty(value = "持续时间")
    private Double duration;

    @ApiModelProperty(value = "爬距计算电压")
    private Double creepageCalculationVoltage;

    @ApiModelProperty(value = "预期寿命")
    private Integer lifeExpectancy;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "通用设计编号")
    private String generalDesignNum;


}
