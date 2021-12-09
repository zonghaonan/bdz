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
@ApiModel(value="GwCompleteAndSetgroundingTransformer对象", description="")
public class GwCompleteAndSetgroundingTransformer implements Serializable {

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

    @ApiModelProperty(value = "通用设备编号")
    private String generalEquipmentNumber;

    @ApiModelProperty(value = "防护等级")
    private String degreeOfProtection;

    @ApiModelProperty(value = "使用状况")
    private int status;
}
