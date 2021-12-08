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
@ApiModel(value="GwStationPowerCabinet对象", description="")
public class GwStationPowerCabinet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 35kV隔离柜")
    private String modelName;

    @ApiModelProperty(value = "设备名称")
    private String equipmentName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "相数")
    private String phaseNumber;

    @ApiModelProperty(value = "系统标称电压")
    private Double systemNominalVoltage;

    @ApiModelProperty(value = "设备最高电压")
    private Double maximumVoltageOfEquipment;

    @ApiModelProperty(value = "电源的频率")
    private Double frequencyOfPowerSupply;

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "柜深")
    private Double cabinetDepth;

    @ApiModelProperty(value = "柜宽")
    private Double cabinetWidth;

    @ApiModelProperty(value = "柜高")
    private Double cabinetHeight;

    @ApiModelProperty(value = "使用状况")
    private int status;}
