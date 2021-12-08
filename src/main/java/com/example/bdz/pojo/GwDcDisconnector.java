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
@ApiModel(value="GwDcDisconnector对象", description="")
public class GwDcDisconnector implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 旁路开关")
    private String modelName;

    @ApiModelProperty(value = "额定电压")
    private Double ratedVoltage;

    @ApiModelProperty(value = "最高电压")
    private Double ceilingVoltage;

    @ApiModelProperty(value = "确定爬电距离的电压")
    private Double voltageForDeterminingCreepageDistance;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
