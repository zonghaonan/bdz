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
@ApiModel(value="GwCabinetSvg对象", description="")
public class GwCabinetSvg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 柜式SVG")
    private String modelName;

    @ApiModelProperty(value = "型号")
    private String model;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "补偿容量	")
    private Double compensationCapacity;

    @ApiModelProperty(value = "谐波特性")
    private Double harmonicCharacteristics;

    @ApiModelProperty(value = "控制电源")
    private Double controlPowerSupply;

    @ApiModelProperty(value = "冷却方式")
    private String coolingMode;

    @ApiModelProperty(value = "运行模式")
    private String operationMode;

    @ApiModelProperty(value = "安装方式")
    private String installationMode;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "PMS设备ID号")
    private Double pmsEquipmentId;

    @ApiModelProperty(value = "电网标识系统编号")
    private Double gridIdentificationSystemNumber;

    @ApiModelProperty(value = "物料编号")
    private Double itemNumber;

    @ApiModelProperty(value = "调度编码")
    private Double schedulingCode;

    @ApiModelProperty(value = "使用状况")
    private int status;

}
